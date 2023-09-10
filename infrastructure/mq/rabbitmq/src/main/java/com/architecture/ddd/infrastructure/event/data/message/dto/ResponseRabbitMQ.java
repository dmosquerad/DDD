package com.architecture.ddd.infrastructure.data.message.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serial;
import java.io.Serializable;

//TODO: try avoid use Encapsulation Pattern for get exceptions
@Value
@Builder
@Jacksonized
public class ResponseRabbitMQ<T extends Serializable> implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 3693104397035480321L;

    T value;

    Throwable exception;

}
