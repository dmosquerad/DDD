package com.architecture.ddd.application.rest.clientapi_command.service.impl;

import com.architecture.ddd.application.rest.clientapi_command.service.UserCommandServiceController;
import com.architecture.ddd.domain.commandeventhandler.mapper.event.UserEventMapper;
import com.architecture.ddd.domain.data.boundary.mapper.UserVoMapper;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.UUID;

@Service(UserServiceControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserServiceControllerImpl implements UserCommandServiceController {

    public final static String BEAN = "userServiceControllerImpl";

    @NonNull
    private final ApplicationEventPublisher applicationEventPublisher;

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @Override
    @Transactional
    public UserVo createUser(@NonNull final UserVo userVo) {
        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserCreateEvent(userVo));

        return userVo;
    }

    @Override
    @Transactional
    public UserVo deleteUserByUuid(@NonNull final UUID uuid) {
        UserVo existUserVo = this.userService.getUserByUuid(uuid);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserDeleteEvent(existUserVo));

        return existUserVo;
    }

    @Override
    @Transactional
    public UserVo createOrUpdateUser(@NonNull final UserVo userVo) {
        //Mejorar
        UserVo existUserVo = this.userService.getUserByUuid(userVo.getUuid());
        userVo.setId(existUserVo.getId());

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserPutEvent(userVo));

        return userVo;
    }

    @Override
    @Transactional
    public UserVo updateUser(@NonNull final UserVo userVo) {
        UserVo existUserVo = this.userService.getUserByUuid(userVo.getUuid());

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        UserVo userVoCurrent = UserVoMapper.INSTANCE.updateUserVo(existUserVo, userVo);

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserPatchEvent(userVoCurrent));

        return userVoCurrent;
    }
}
