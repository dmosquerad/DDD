package com.architecture.ddd.infrastructure.mq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UserHandlerComponent {

    @RabbitListener(queues = "")
    public void handleUserCreate(String message) {

    }

    @RabbitListener(queues = "")
    public void handleUserUpdate(String message) {

    }

    @RabbitListener(queues = "")
    public void handleUserDelete(String message) {

    }


}

