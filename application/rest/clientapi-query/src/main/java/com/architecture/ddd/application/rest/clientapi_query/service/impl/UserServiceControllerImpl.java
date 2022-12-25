package com.architecture.ddd.application.rest.clientapi_query.service.impl;

import com.architecture.ddd.application.rest.clientapi_query.boundary.component.UserControllerBoundary;
import com.architecture.ddd.application.rest.clientapi_query.boundary.component.impl.UserControllerBoundaryImpl;
import com.architecture.ddd.application.rest.clientapi_query.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_query.service.UserServiceController;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.validation.service.UserValidationService;
import com.architecture.ddd.infrastructure.validation.service.impl.UserValidationServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.UUID;

@Service(UserServiceControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserServiceControllerImpl implements UserServiceController {

    public final static String BEAN = "UserServiceControllerImpl";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @NonNull
    @Qualifier(UserValidationServiceImpl.BEAN)
    private final UserValidationService userValidationService;

    @NonNull
    @Qualifier(UserControllerBoundaryImpl.BEAN)
    private final UserControllerBoundary userControllerBoundary;

    @Override
    public ResponseEntity<ResponseUser> getAllUsers() {
        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(this.userControllerBoundary.toUserDto(this.userService.getUserAll()))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> getUserById(String id) {
        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userControllerBoundary.toUserDto(this.userService.getUserById(id))))
                .build());
    }

}
