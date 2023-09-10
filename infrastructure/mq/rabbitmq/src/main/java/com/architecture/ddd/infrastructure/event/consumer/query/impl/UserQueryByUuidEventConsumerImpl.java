package com.architecture.ddd.infrastructure.event.consumer.query.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.data.message.dto.ResponseRabbitMQ;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.event.consumer.query.UserQueryByUuidEventConsumer;
import com.architecture.ddd.infrastructure.mapper.dto.UserMessageDtoMapper;
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
                value = @Queue(value = UserQueryByUuidEventConsumerImpl.QUEUE, durable = "true"),
                exchange = @Exchange(name = "amq.direct"),
                key = UserQueryByUuidEventConsumerImpl.KEY
        )
)
public class UserQueryByUuidEventConsumerImpl implements UserQueryByUuidEventConsumer {

    public static final String QUEUE = "int/users.queue-query-by-uuid";
    public static final String KEY = "QUERY-BY-UUID";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @RabbitHandler
    @Transactional
    public ResponseRabbitMQ<UserMessageDto> handler(@Payload @NonNull final UserMessageDto userMessageDto) {
        final UserVo userVo = userService.getUserByUuid(userMessageDto.getUuid());

        return ResponseRabbitMQ.<UserMessageDto>builder()
                .value(UserMessageDtoMapper.INSTANCE.toUserMessageDto(userVo == null ? UserVo.builder().build() : userVo))
                .build();
    }
}
