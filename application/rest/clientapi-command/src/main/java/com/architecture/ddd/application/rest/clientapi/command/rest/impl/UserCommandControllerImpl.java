package com.architecture.ddd.application.rest.clientapi.command.rest.impl;

import com.architecture.ddd.application.rest.clientapi.command.adapter.UserCommandControllerAdapter;
import com.architecture.ddd.application.rest.clientapi.command.adapter.impl.UserCommandControllerAdapterImpl;
import com.architecture.ddd.application.rest.clientapi.command.mapper.dto.UserDtoMapper;
import com.architecture.ddd.application.rest.clientapi.command.mapper.vo.UserVoMapper;
import com.architecture.ddd.application.rest.clientapi.command.rest.UsersApi;
import com.architecture.ddd.application.rest.clientapi_command.dto.ResponseUserDto;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBodyDto;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBodyNonRequiredDto;
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
    public ResponseEntity<ResponseUserDto> createUser(@NonNull final UserBodyDto userBodyDto) {
        final UserVo userVo = this.userCommandControllerAdapter.createUser(UserVoMapper.INSTANCE.toUserVo(userBodyDto));

        return ResponseEntity.ok(ResponseUserDto.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUserDto> deleteUserByUuid(@NonNull final UUID userUuid) {
        final UserVo userVo = this.userCommandControllerAdapter.deleteUserByUuid(userUuid);

        return ResponseEntity.ok(ResponseUserDto.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUserDto> createOrUpdateUserByUuid(@NonNull final UUID userUuid, @NonNull final UserBodyDto userBodyDto) {
        final UserVo userVo = this.userCommandControllerAdapter.createOrUpdateUser(UserVoMapper.INSTANCE.toUserVoFromUuidAndUserBodyDto(userUuid, userBodyDto));

        return ResponseEntity.ok(ResponseUserDto.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(userVo)))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUserDto> updateUserByUuid(@NonNull final UUID userUuid, @NonNull final UserBodyNonRequiredDto userBodyNonRequiredDto) {
        final UserVo userVo = this.userCommandControllerAdapter.updateUser(UserVoMapper.INSTANCE.toUserVoFromUuidAndUserBodyNonRequiredDto(userUuid, userBodyNonRequiredDto));

        return ResponseEntity.ok(ResponseUserDto.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(UserDtoMapper.INSTANCE.toUserDto(userVo)))
                .build());
    }
}
