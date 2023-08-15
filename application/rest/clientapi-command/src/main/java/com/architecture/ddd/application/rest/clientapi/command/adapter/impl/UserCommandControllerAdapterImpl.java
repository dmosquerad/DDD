package com.architecture.ddd.application.rest.clientapi.command.adapter.impl;

import com.architecture.ddd.application.rest.clientapi.command.adapter.UserCommandControllerAdapter;
import com.architecture.ddd.application.rest.clientapi.command.mapper.vo.UserVoMapper;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.validation.util.UserValidationUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.UUID;

@Component(UserCommandControllerAdapterImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandControllerAdapterImpl implements UserCommandControllerAdapter {

    public static final String BEAN = "userCommandControllerAdapterImpl";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @Override
    @Transactional
    public UserVo createUser(@NonNull final UserVo userVo) {
        return this.userService.saveUser(userVo);
    }

    @Override
    @Transactional
    public UserVo deleteUserByUuid(@NonNull final UUID uuid) {
        UserVo existUserVo = this.userService.getUserByUuid(uuid);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return this.userService.deleteUser(existUserVo);
    }

    @Override
    @Transactional
    public UserVo createOrUpdateUser(@NonNull final UserVo userVo) {
        UserVo existUserVo = this.userService.getUserByUuid(userVo.getUuid());

        UserVo userVoCurrent = UserVoMapper.INSTANCE.toUserVoFromId(existUserVo.getId(), userVo);

        return this.userService.saveUser(userVoCurrent);
    }

    @Override
    @Transactional
    public UserVo updateUser(@NonNull final UserVo userVo) {
        UserVo existUserVo = this.userService.getUserByUuid(userVo.getUuid());

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        UserVo userVoCurrent = UserValidationUtil.validateUserVoToUpdate(existUserVo, userVo);

        return this.userService.saveUser(userVoCurrent);
    }
}