package com.architecture.ddd.application.rest.clientapi.query.adapter;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;
import java.util.UUID;

public interface UserQueryControllerAdapter {

    List<UserVo> getAllUsers();

    UserVo getUserByUuid(UUID uuid);
}
