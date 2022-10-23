package com.architecture.ddd.application.rest.clientapi.service.impl;

import com.architecture.ddd.application.rest.clientapi.boundary.component.UserControllerBoundary;
import com.architecture.ddd.application.rest.clientapi.boundary.component.impl.UserControllerBoundaryImpl;
import com.architecture.ddd.application.rest.clientapi.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi.service.UserServiceController;
import com.architecture.ddd.domain.data.vo.UserVo;
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
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Objects;
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

    @Override
    public ResponseEntity<ResponseUser> createUser(UserBody userBody) {
        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userControllerBoundary.toUserDto(this.userService.saveUser(this.userControllerBoundary.toUserVo(userBody)))))
                .build());
    }
    
    @Override
    @Transactional
    public ResponseEntity<ResponseUser> deleteUserById(String id) {
        UserVo existUserVo = this.userValidationService.isValidUserVo(id);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userControllerBoundary.toUserDto(this.userService.deleteUser(existUserVo))))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> putUserById(String id, UserBody userBody) {
        UserVo existUserVo = this.userValidationService.isValidUserVo(id);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userControllerBoundary.toUserDto(this.userService.updateUser(this.userControllerBoundary.toUserVo(id, userBody)))))
                .build());
    }

    @Override
    public ResponseEntity<ResponseUser> patchUserByUUID(String id, UserBody userBody) {
        UserVo existUserVo = this.userValidationService.isValidUserVo(id);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(ResponseUser.builder()
                .uuid(UUID.randomUUID())
                .date(OffsetDateTime.now())
                .status(String.valueOf(HttpStatus.OK.value()))
                .code(String.valueOf(HttpStatus.OK.value()))
                .data(Collections.singletonList(this.userControllerBoundary.toUserDto(
                        this.userService.updateUser(this.userControllerBoundary.toUserVoUpdate(userBody, existUserVo)))))
                .build());
    }
}
