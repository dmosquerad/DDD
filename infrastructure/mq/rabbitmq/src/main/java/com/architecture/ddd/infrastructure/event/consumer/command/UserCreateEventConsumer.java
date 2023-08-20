package com.architecture.ddd.infrastructure.event.consumer.command;

import com.architecture.ddd.infrastructure.data.message.dto.ResponseRabbitMQ;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;

public interface UserCreateEventConsumer {

    ResponseRabbitMQ<UserMessageDto> handler(UserMessageDto userMessageDto);
}
