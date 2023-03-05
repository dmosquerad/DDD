package com.architecture.ddd.application.rest.clientapi.query.boundary.component.impl;

import com.architecture.ddd.application.rest.clientapi.query.boundary.component.UserQueryControllerBoundary;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service(UserQueryControllerBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class UserQueryControllerBoundaryImpl implements UserQueryControllerBoundary {

    public static final String BEAN = "userQueryControllerBoundaryImpl";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @Override
    public List<UserVo> getAllUsers() {
        return this.userService.getUserAll();
    }

    @Override
    public UserVo getUserByUuid(@NonNull final UUID uuid) {
        return this.userService.getUserByUuid(uuid);
    }

}
