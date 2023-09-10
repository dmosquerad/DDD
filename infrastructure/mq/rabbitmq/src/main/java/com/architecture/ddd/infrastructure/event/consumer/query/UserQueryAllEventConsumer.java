package com.architecture.ddd.infrastructure.event.consumer.query;

import com.architecture.ddd.infrastructure.data.message.dto.ResponseRabbitMQ;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;

import java.util.ArrayList;

//TODO: split response on handler and avoid send empty body
public interface UserQueryAllEventConsumer {

    ResponseRabbitMQ<ArrayList<UserMessageDto>> handler(UserMessageDto userMessageDto);
}
