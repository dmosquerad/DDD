package com.architecture.ddd.application.rest.clientapi.command;


import com.architecture.ddd.application.rest.clientapi_command.dto.ResponseErrorDto;
import org.springframework.amqp.AmqpException;;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//TODO: Add exception handlers, adn unify controllerAdvise for query and command
@ControllerAdvice
public class ControllerAdvise extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AmqpException.class)
    public final ResponseEntity<ResponseErrorDto> handleAmqpException(AmqpException e){
        //TODO: Do Exception handler
        return null;
    }
}

