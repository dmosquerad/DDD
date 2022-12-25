package com.architecture.ddd.application.rest.clientapi_command.boundary.component;

import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;

public interface UserCommandControllerBoundary {

    UserDto toUserDto(UserVo userVo);

    UserVo toUserVoPost(UserBody userBody);

    UserVo toUserVoPut(UserVo userVo, UserBody userBody);

    UserVo toUserVoPatch(UserVo userVoTarget, UserBody userBody);
}