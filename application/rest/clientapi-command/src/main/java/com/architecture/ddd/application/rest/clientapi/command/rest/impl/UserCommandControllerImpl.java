package com.architecture.ddd.application.rest.clientapi.command.rest.impl;

import com.architecture.ddd.application.rest.clientapi.command.adapter.UserCommandControllerAdapter;
import com.architecture.ddd.application.rest.clientapi.command.adapter.impl.UserCommandControllerAdapterImpl;
import com.architecture.ddd.application.rest.clientapi.command.mapper.dto.UserDtoMapper;
import com.architecture.ddd.application.rest.clientapi.command.mapper.vo.UserVoMapper;
import com.architecture.ddd.application.rest.clientapi.command.rest.UsersApi;
import com.architecture.ddd.application.rest.clientapi_command.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBodyNonRequired;
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

    public static final String BEAN = "userCommandControllerImpl";

    @NonNull
    @Qualifier(UserCommandControllerAdapterImpl.BEAN)
    private final UserCommandControllerAdapter userCommandControllerAdapter;

    @Override
    public ResponseEntity<ResponseUser> createUser(@NonNull final UserBody userBody) {
        UserVo userVo = this.userCommandControllerAdapter.createUser(UserVoMapper.INSTANCE.toUserVo(userBody));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> deleteUserByUuid(@NonNull final UUID userUuid) {
        UserVo userVo = this.userCommandControllerAdapter.deleteUserByUuid(userUuid);

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> createOrUpdateUserByUuid(@NonNull final UUID userUuid, @NonNull final UserBody userBody) {
        UserVo userVo = this.userCommandControllerAdapter.createOrUpdateUser(UserVoMapper.INSTANCE.toUserVoFromUuidAndUserBody(userUuid, userBody));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> updateUserByUuid(@NonNull final UUID userUuid, @NonNull final UserBodyNonRequired userBodyNonRequired) {
        UserVo userVo = this.userCommandControllerAdapter.updateUser(UserVoMapper.INSTANCE.toUserVoFromUuidAndUserBodyNonRequired(userUuid, userBodyNonRequired));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(userVo)))
                .build());
    }
}
