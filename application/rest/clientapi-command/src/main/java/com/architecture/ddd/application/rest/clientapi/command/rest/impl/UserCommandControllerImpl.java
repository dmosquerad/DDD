package com.architecture.ddd.application.rest.clientapi.command.rest.impl;

import com.architecture.ddd.application.rest.clientapi.command.boundary.component.UserCommandControllerBoundary;
import com.architecture.ddd.application.rest.clientapi.command.boundary.component.impl.UserCommandControllerBoundaryImpl;
import com.architecture.ddd.application.rest.clientapi.command.rest.UsersApi;
import com.architecture.ddd.application.rest.clientapi.command.service.UserCommandServiceController;
import com.architecture.ddd.application.rest.clientapi.command.service.impl.UserCommandServiceControllerImpl;
import com.architecture.ddd.application.rest.clientapi_command.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.UUID;

@RestController(UserCommandControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandControllerImpl implements UsersApi {

    public final static String BEAN = "userCommandControllerImpl";

    @NonNull
    @Qualifier(UserCommandServiceControllerImpl.BEAN)
    private final UserCommandServiceController userCommandServiceController;

    @NonNull
    @Qualifier(UserCommandControllerBoundaryImpl.BEAN)
    private final UserCommandControllerBoundary userCommandControllerBoundary;

    @Override
    public ResponseEntity<ResponseUser> createUser(@NonNull final UserBody userBody) {
        UserVo userVo = this.userCommandServiceController.createUser(this.userCommandControllerBoundary.toUserVo(userBody));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userCommandControllerBoundary.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> deleteUserByUuid(@NonNull final UUID userUuid) {
        UserVo userVo = this.userCommandServiceController.deleteUserByUuid(userUuid);

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userCommandControllerBoundary.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> createOrUpdateUserByUuid(@NonNull final UUID userUuid, @NonNull final UserBody userBody) {
        UserVo userVo = this.userCommandServiceController.createOrUpdateUser(this.userCommandControllerBoundary.toUserVoFromUserBodyAndUuid(userUuid, userBody));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userCommandControllerBoundary.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> updateUserByUuid(@NonNull final UUID userUuid, @NonNull final UserBody userBody) {
        UserVo userVo = this.userCommandServiceController.updateUser(this.userCommandControllerBoundary.toUserVoFromUserBodyAndUuid(userUuid, userBody));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userCommandControllerBoundary.toUserDto(userVo)))
                .build());
    }
}
