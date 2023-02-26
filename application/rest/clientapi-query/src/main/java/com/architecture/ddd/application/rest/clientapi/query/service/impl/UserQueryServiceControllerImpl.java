package com.architecture.ddd.application.rest.clientapi.query.service.impl;

import com.architecture.ddd.application.rest.clientapi.query.service.UserQueryServiceController;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.validation.service.UserValidationService;
import com.architecture.ddd.infrastructure.validation.service.impl.UserValidationServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service(UserQueryServiceControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserQueryServiceControllerImpl implements UserQueryServiceController {

    public final static String BEAN = "userQueryServiceControllerImpl";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @NonNull
    @Qualifier(UserValidationServiceImpl.BEAN)
    private final UserValidationService userValidationService;

    @Override
    public List<UserVo> getAllUsers() {
        return this.userService.getUserAll();
    }

    @Override
    public UserVo getUserByUuid(@NonNull final UUID uuid) {
        return this.userService.getUserByUuid(uuid);
    }

}
