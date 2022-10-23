package com.architecture.ddd.infrastructure.validation.service;

import com.architecture.ddd.domain.data.vo.UserVo;

public interface UserValidationService {

    UserVo isValidUserVo(String id);
}
