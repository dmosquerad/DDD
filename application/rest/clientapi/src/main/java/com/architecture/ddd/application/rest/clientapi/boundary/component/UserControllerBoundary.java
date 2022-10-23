package com.architecture.ddd.application.rest.clientapi.boundary.component;

import com.architecture.ddd.application.rest.clientapi.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;

public interface UserControllerBoundary {

    UserDto toUserDto(UserVo userVo);

    List<UserDto> toUserDto(List<UserVo> userVo);

    UserVo toUserVo(UserBody userBody);

    UserVo toUserVo(String id, UserBody userBody);

    UserVo toUserVoUpdate(UserBody userBody, UserVo userVo);
}