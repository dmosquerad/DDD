package com.architecture.ddd.infrastructure.validation.service.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.validation.service.UserValidationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service(UserValidationServiceImpl.BEAN)
@RequiredArgsConstructor
public class UserValidationServiceImpl implements UserValidationService {

    public final static String BEAN = "userValidationServiceImpl";


    @Override
    public Boolean isValidUserVo(@NonNull final UserVo userVo) {
        return true;
    }
}
