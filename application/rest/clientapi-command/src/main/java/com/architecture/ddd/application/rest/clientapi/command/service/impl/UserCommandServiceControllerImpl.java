package com.architecture.ddd.application.rest.clientapi.command.service.impl;

import com.architecture.ddd.application.rest.clientapi.command.service.UserCommandServiceController;
import com.architecture.ddd.domain.data.boundary.component.UserHandlerBoundary;
import com.architecture.ddd.domain.data.boundary.component.impl.UserHandlerHandlerBoundaryImpl;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.UUID;

@Service(UserCommandServiceControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandServiceControllerImpl implements UserCommandServiceController {

    public final static String BEAN = "userServiceControllerImpl";

    @NonNull
    @Qualifier(UserHandlerHandlerBoundaryImpl.BEAN)
    private final UserHandlerBoundary userHandlerBoundary;

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

        UserVo userVoCurrent = this.userHandlerBoundary.toUserVoFromId(existUserVo.getId(), userVo);

        return this.userService.saveUser(userVoCurrent);
    }

    @Override
    @Transactional
    public UserVo updateUser(@NonNull final UserVo userVo) {
        UserVo existUserVo = this.userService.getUserByUuid(userVo.getUuid());

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        UserVo userVoCurrent = this.userHandlerBoundary.updateUserVo(existUserVo, userVo);

        return this.userService.saveUser(userVoCurrent);
    }
}