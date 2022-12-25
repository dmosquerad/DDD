package com.architecture.ddd.application.rest.clientapi_query.boundary.component;

import com.architecture.ddd.application.rest.clientapi_query.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;

public interface UserQueryControllerBoundary {

    UserDto toUserDto(UserVo userVo);

    List<UserDto> toUserDto(List<UserVo> userVo);
}