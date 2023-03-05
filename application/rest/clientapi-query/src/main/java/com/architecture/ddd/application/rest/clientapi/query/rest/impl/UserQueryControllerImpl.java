package com.architecture.ddd.application.rest.clientapi.query.rest.impl;

import com.architecture.ddd.application.rest.clientapi.query.boundary.component.UserQueryControllerBoundary;
import com.architecture.ddd.application.rest.clientapi.query.boundary.component.impl.UserQueryControllerBoundaryImpl;
import com.architecture.ddd.application.rest.clientapi.query.boundary.mapper.dto.UserDtoMapper;
import com.architecture.ddd.application.rest.clientapi.query.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi.query.rest.UsersApi;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.UUID;

@RestController(UserQueryControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserQueryControllerImpl implements UsersApi {

    public static final String BEAN = "userQueryControllerImpl";

    @NonNull
    @Qualifier(UserQueryControllerBoundaryImpl.BEAN)
    private final UserQueryControllerBoundary userQueryControllerBoundary;

    @Override
    public ResponseEntity<ResponseUser> getAllUsers() {
        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(UserDtoMapper.INSTANCE.toUserDto(this.userQueryControllerBoundary.getAllUsers()))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> getUserByUuid(@NonNull final UUID userUuid) {
        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(this.userQueryControllerBoundary.getUserByUuid(userUuid))))
                .build());
    }

}
