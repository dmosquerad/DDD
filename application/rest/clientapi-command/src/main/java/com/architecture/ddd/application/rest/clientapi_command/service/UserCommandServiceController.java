package com.architecture.ddd.application.rest.clientapi_command.service;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.UUID;

public interface UserCommandServiceController {

    UserVo createUser(UserVo userVo);

    UserVo deleteUserByUuid(UUID uuid);

    UserVo createOrUpdateUser(UserVo userVo);

    UserVo updateUser(UserVo userVo);
}
