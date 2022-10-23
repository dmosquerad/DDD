package com.architecture.ddd.domain.service.microservice.service;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;

public interface UserService {

    UserVo getFistUser();

    List<UserVo> getUserAll();

    UserVo getUserById(String id);

    UserVo saveUser(UserVo userVo);

    UserVo updateUser(UserVo userVo);

    UserVo deleteUser(UserVo userVo);
}
