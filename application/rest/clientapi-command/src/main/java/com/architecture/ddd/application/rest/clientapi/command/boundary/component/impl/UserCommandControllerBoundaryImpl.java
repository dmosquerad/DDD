package com.architecture.ddd.application.rest.clientapi.command.boundary.component.impl;

import com.architecture.ddd.application.rest.clientapi.command.boundary.component.UserCommandControllerBoundary;
import com.architecture.ddd.application.rest.clientapi.command.boundary.mapper.dto.UserDtoMapper;
import com.architecture.ddd.application.rest.clientapi.command.boundary.mapper.vo.UserVoMapper;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component(UserCommandControllerBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandControllerBoundaryImpl implements UserCommandControllerBoundary {

    public final static String BEAN = "userControllerBoundaryImpl";

    @Override
    public UserDto toUserDto(@NonNull final UserVo userVo) {
        return UserDtoMapper.INSTANCE.toUserDto(userVo);
    }

    @Override
    public UserVo toUserVo(@NonNull final UserBody userBody) {
        return UserVoMapper.INSTANCE.toUserVo(userBody);
    }

    @Override
    public UserVo toUserVoFromUserBodyAndUuid(@NonNull final UUID uuid, @NonNull final UserBody userBody) {
        return UserVoMapper.INSTANCE.toUserVoFromUserBodyAndUuid(uuid, userBody);
    }

}
