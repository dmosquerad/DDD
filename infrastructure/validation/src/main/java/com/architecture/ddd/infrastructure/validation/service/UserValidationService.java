package com.architecture.ddd.infrastructure.validation.service;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.UUID;

public interface UserValidationService {

    UserVo isValidUserVo(UUID uuid);
}
