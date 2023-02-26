package com.architecture.ddd.application.rest.clientapi.query.boundary.component;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;
import java.util.UUID;

public interface UserQueryControllerBoundary {

    List<UserVo> getAllUsers();

    UserVo getUserByUuid(UUID uuid);
}
