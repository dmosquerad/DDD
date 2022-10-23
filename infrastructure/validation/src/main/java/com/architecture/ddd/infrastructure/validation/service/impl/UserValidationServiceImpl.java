package com.architecture.ddd.infrastructure.validation.service.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.validation.service.UserValidationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(UserValidationServiceImpl.BEAN)
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {

    public final static String BEAN = "userValidationServiceImpl";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @Override
    public UserVo isValidUserVo(String id) {
        return this.userService.getUserById(id);
    }
}
