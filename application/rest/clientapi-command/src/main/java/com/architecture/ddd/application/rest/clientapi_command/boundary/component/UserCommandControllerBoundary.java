package com.architecture.ddd.application.rest.clientapi_command.boundary.component;

import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.UUID;

public interface UserCommandControllerBoundary {

    UserDto toUserDto(UserVo userVo);

    UserVo toUserVo(UserBody userBody);

    UserVo toUserVoFromUserBodyAndUuid(UUID uuid, UserBody userBody);
}