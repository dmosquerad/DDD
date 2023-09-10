package com.architecture.ddd.infrastructure.event.consumer.command.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.data.message.dto.ResponseRabbitMQ;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.event.consumer.command.UserCreateEventConsumer;
import com.architecture.ddd.infrastructure.mapper.dto.UserMessageDtoMapper;
import com.architecture.ddd.infrastructure.mapper.vo.UserVoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//TODO: Unify consumers and try to use key or queue only for difference actions
@Component
@RequiredArgsConstructor
@RabbitListener(returnExceptions = "true",
        bindings = @QueueBinding(
                value = @Queue(value = UserCreateEventConsumerImpl.QUEUE, durable = "true"),
                exchange = @Exchange(name = "amq.direct"),
                key = UserCreateEventConsumerImpl.KEY
        )
)
public class UserCreateEventConsumerImpl implements UserCreateEventConsumer {

    public static final String QUEUE = "int/users.queue-create";
    public static final String KEY = "CREATE";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @RabbitHandler
    @Transactional
    public ResponseRabbitMQ<UserMessageDto> handler(@Payload @NonNull final UserMessageDto userMessageDto) {
        final UserVo userVo = userService.saveUser(UserVoMapper.INSTANCE.toUserVo(userMessageDto));

        return ResponseRabbitMQ.<UserMessageDto>builder()
                .value(UserMessageDtoMapper.INSTANCE.toUserMessageDto(userVo))
                .build();
    }
}
