package com.architecture.ddd.infrastructure.event.consumer.query;

import com.architecture.ddd.infrastructure.data.message.dto.ResponseRabbitMQ;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;

//TODO: send only uuid
public interface UserQueryByUuidEventConsumer {

    ResponseRabbitMQ<UserMessageDto> handler(UserMessageDto userMessageDto);
}
