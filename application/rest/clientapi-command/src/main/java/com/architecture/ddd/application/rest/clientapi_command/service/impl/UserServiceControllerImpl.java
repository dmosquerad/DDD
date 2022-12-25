package com.architecture.ddd.application.rest.clientapi_command.service.impl;

import com.architecture.ddd.application.rest.clientapi_command.boundary.component.UserCommandControllerBoundary;
import com.architecture.ddd.application.rest.clientapi_command.boundary.component.impl.UserCommandControllerBoundaryImpl;
import com.architecture.ddd.application.rest.clientapi_command.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi_command.service.UserCommandServiceController;
import com.architecture.ddd.domain.commandeventhandler.mapper.event.UserEventMapper;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.validation.service.UserValidationService;
import com.architecture.ddd.infrastructure.validation.service.impl.UserValidationServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

@Service(UserServiceControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserServiceControllerImpl implements UserCommandServiceController {

    public final static String BEAN = "UserServiceControllerImpl";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @NonNull
    @Qualifier(UserValidationServiceImpl.BEAN)
    private final UserValidationService userValidationService;

    @NonNull
    @Qualifier(UserCommandControllerBoundaryImpl.BEAN)
    private final UserCommandControllerBoundary userCommandControllerBoundary;

    @NonNull
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    @Transactional
    public ResponseEntity<ResponseUser> createUser(UserBody userBody) {
        UserVo userVo = this.userCommandControllerBoundary.toUserVoPost(userBody);

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserCreateEvent(userVo));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userCommandControllerBoundary.toUserDto(userVo)))
                .build());
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseUser> deleteUserByUuid(UUID uuid) {
        UserVo userVo = this.userValidationService.isValidUserVo(uuid);

        if (Objects.isNull(userVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserDeleteEvent(userVo));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userCommandControllerBoundary.toUserDto(userVo)))
                .build());
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseUser> putUserByUuid(UUID uuid, UserBody userBody) {
        UserVo existUserVo = this.userValidationService.isValidUserVo(uuid);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        UserVo userVo = this.userCommandControllerBoundary.toUserVoPut(existUserVo, userBody);

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserPutEvent(userVo));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userCommandControllerBoundary.toUserDto(userVo)))
                .build());
    }

    @Override
    @Transactional
    public ResponseEntity<ResponseUser> patchUserByUuid(UUID uuid, UserBody userBody) {
        UserVo existUserVo = this.userValidationService.isValidUserVo(uuid);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        UserVo userVo = this.userCommandControllerBoundary.toUserVoPatch(existUserVo, userBody);
        
        /*
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserPatchEvent(userVo));
            return null;
        });
         */

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserPatchEvent(userVo));

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userCommandControllerBoundary.toUserDto(userVo)))
                .build());
    }
}
