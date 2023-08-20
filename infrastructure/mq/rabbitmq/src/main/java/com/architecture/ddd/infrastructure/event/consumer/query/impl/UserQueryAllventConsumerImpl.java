package com.architecture.ddd.infrastructure.event.consumer.query.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.data.message.dto.ResponseRabbitMQ;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;
import com.architecture.ddd.infrastructure.event.consumer.query.UserQueryAllEventConsumer;
import com.architecture.ddd.infrastructure.mapper.dto.UserMessageDtoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//TODO: Unify consumers and try to use key or queue only for difference actions
@Component
@RequiredArgsConstructor
@RabbitListener(returnExceptions = "true",
        bindings = @QueueBinding(
                value = @Queue(value = UserQueryAllventConsumerImpl.QUEUE, durable = "true"),
                exchange = @Exchange(name = "amq.direct"),
                key = UserQueryAllventConsumerImpl.KEY
        )
)
public class UserQueryAllventConsumerImpl implements UserQueryAllEventConsumer {

    public static final String QUEUE = "int/users.queue-query-all";
    public static final String KEY = "QUERY-ALL";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    //TODO: Use arraylist because is serialize, but try to send a correct object no a empty and no usable value
    @RabbitHandler
    @Transactional
    public ResponseRabbitMQ<ArrayList<UserMessageDto>> handler(@Payload @NonNull final UserMessageDto userMessageDto) {
        final List<UserVo> userVo = userService.getUserAll();

        return ResponseRabbitMQ.<ArrayList<UserMessageDto>>builder()
                .value(UserMessageDtoMapper.INSTANCE.toUserMessageDto(userVo))
                .build();
    }
}
