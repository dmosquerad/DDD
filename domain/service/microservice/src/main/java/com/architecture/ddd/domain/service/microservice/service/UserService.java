package com.architecture.ddd.domain.service.microservice.service;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserVo getFistUser();

    List<UserVo> getUserAll();

    UserVo getUserById(String id);

    UserVo getUserByUuid(UUID uuid);

    UserVo saveUser(UserVo userVo);

    UserVo updateUser(UserVo userVo);

    UserVo deleteUser(UserVo userVo);
}
