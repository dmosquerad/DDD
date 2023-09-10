package com.architecture.ddd.infrastructure.event.producer.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.data.message.dto.ResponseRabbitMQ;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;
import com.architecture.ddd.infrastructure.event.consumer.command.impl.UserCreateEventConsumerImpl;
import com.architecture.ddd.infrastructure.event.consumer.query.impl.UserQueryAllventConsumerImpl;
import com.architecture.ddd.infrastructure.event.consumer.query.impl.UserQueryByUuidEventConsumerImpl;
import com.architecture.ddd.infrastructure.event.producer.UserEventProducer;
import com.architecture.ddd.infrastructure.mapper.dto.UserMessageDtoMapper;
import com.architecture.ddd.infrastructure.mapper.vo.UserVoMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

//TODO: Maybe think in divide actions by CQRS, check if is best generate exchange for every action, add future actions for avoid synchronous actions
@Component(UserEventProducerImpl.BEAN)
@RequiredArgsConstructor
public class UserEventProducerImpl implements UserEventProducer {

    public static final String BEAN = "userEventProducerImpl";

    @NonNull
    private final ObjectMapper objectMapper;

    @NonNull
    private final RabbitTemplate rabbitTemplate;

    @Override
    public UserVo senderAndReceiveCreate(@NonNull final UserVo userVo) {
        ResponseRabbitMQ<UserMessageDto> responseUserMessageDto = objectMapper.convertValue(
                rabbitTemplate.convertSendAndReceive("amq.direct",
                        UserCreateEventConsumerImpl.KEY,
                        UserMessageDtoMapper.INSTANCE.toUserMessageDto(userVo)),
                new TypeReference<ResponseRabbitMQ<UserMessageDto>>() {
                });

        if (Objects.nonNull(responseUserMessageDto.getException())) {
            throw new AmqpException(responseUserMessageDto.getException());
        }

        return UserVoMapper.INSTANCE.toUserVo(responseUserMessageDto.getValue());
    }

    @Override
    public UserVo senderAndReceiveDelete(@NonNull final UserVo userVo) {
        ResponseRabbitMQ<UserMessageDto> responseUserMessageDto = objectMapper.convertValue(
                rabbitTemplate.convertSendAndReceive("amq.direct",
                        UserCreateEventConsumerImpl.KEY,
                        UserMessageDtoMapper.INSTANCE.toUserMessageDto(userVo)),
                new TypeReference<ResponseRabbitMQ<UserMessageDto>>() {
                });

        if (Objects.nonNull(responseUserMessageDto.getException())) {
            throw new AmqpException(responseUserMessageDto.getException());
        }

        return UserVoMapper.INSTANCE.toUserVo(responseUserMessageDto.getValue());
    }

    @Override
    public UserVo senderAndReceiveQueryByUuid(@NonNull final UUID uuid) {
        ResponseRabbitMQ<UserMessageDto> responseUserMessageDto = objectMapper.convertValue(
                rabbitTemplate.convertSendAndReceive("amq.direct",
                        UserQueryByUuidEventConsumerImpl.KEY,
                        UserMessageDtoMapper.INSTANCE.toUserMessageDto(UserVo.builder().uuid(uuid).build())),
                new TypeReference<ResponseRabbitMQ<UserMessageDto>>() {
                });

        if (Objects.nonNull(responseUserMessageDto.getException())) {
            throw new AmqpException(responseUserMessageDto.getException());
        }

        return UserVoMapper.INSTANCE.toUserVo(responseUserMessageDto.getValue());
    }

    @Override
    public List<UserVo> senderAndReceiveQueryAll() {
        ResponseRabbitMQ<ArrayList<UserMessageDto>> responseUserMessageDto = objectMapper.convertValue(
                rabbitTemplate.convertSendAndReceive("amq.direct",
                        UserQueryAllventConsumerImpl.KEY,
                        UserMessageDtoMapper.INSTANCE.toUserMessageDto(UserVo.builder().build())),
                new TypeReference<ResponseRabbitMQ<ArrayList<UserMessageDto>>>() {
                });

        if (Objects.nonNull(responseUserMessageDto.getException())) {
            throw new AmqpException(responseUserMessageDto.getException());
        }

        return UserVoMapper.INSTANCE.toUserVo(responseUserMessageDto.getValue());
    }
}
