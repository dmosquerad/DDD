package com.architecture.ddd.infrastructure.validation.service.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import com.architecture.ddd.infrastructure.validation.service.UserValidationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.UUID;

@Service(UserValidationServiceImpl.BEAN)
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {

    public final static String BEAN = "userValidationServiceImpl";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    //Analizar si volver a usar
    @Override
    public UserVo isValidUserVo(@NonNull final UUID id) {
        UserVo existUserVo = this.userService.getUserByUuid(id);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return existUserVo;
    }
}
