package com.architecture.ddd.application.rest.clientapi_command.boundary.component.impl;

import com.architecture.ddd.application.rest.clientapi_command.boundary.component.UserCommandControllerBoundary;
import com.architecture.ddd.application.rest.clientapi_command.boundary.mapper.dto.UserDtoMapper;
import com.architecture.ddd.application.rest.clientapi_command.boundary.mapper.vo.UserVoMapper;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(UserCommandControllerBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandControllerBoundaryImpl implements UserCommandControllerBoundary {

    public final static String BEAN = "userControllerBoundaryImpl";

    @Override
    public UserDto toUserDto(UserVo userVo) {
        return UserDtoMapper.INSTANCE.toUserDto(userVo);
    }

    @Override
    public UserVo toUserVoPost(UserBody userBody) {
        return UserVoMapper.INSTANCE.toUserVoInsert(userBody);
    }

    @Override
    public UserVo toUserVoPut(UserVo userVo, UserBody userBody) {
        return UserVoMapper.INSTANCE.toUserVoPut(userVo, userBody);
    }

    @Override
    public UserVo toUserVoPatch(UserVo userVo, UserBody userBody) {
        return UserVoMapper.INSTANCE.toUserVoPatch(userVo, userBody);
    }

}
