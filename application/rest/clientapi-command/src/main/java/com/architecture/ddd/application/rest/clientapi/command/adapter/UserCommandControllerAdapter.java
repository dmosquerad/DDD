package com.architecture.ddd.application.rest.clientapi.command.adapter;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.UUID;

public interface UserCommandControllerAdapter {

    UserVo createUser(UserVo userVo);

    UserVo deleteUserByUuid(UUID uuid);

    UserVo createOrUpdateUser(UserVo userVo);

    UserVo updateUser(UserVo userVo);
}
