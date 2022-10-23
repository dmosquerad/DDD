package com.architecture.ddd.application.rest.clientapi.boundary.component.impl;

import com.architecture.ddd.application.rest.clientapi.boundary.component.UserControllerBoundary;
import com.architecture.ddd.application.rest.clientapi.boundary.mapper.dto.UserDtoMapper;
import com.architecture.ddd.application.rest.clientapi.boundary.mapper.vo.UserVoMapper;
import com.architecture.ddd.application.rest.clientapi.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(UserControllerBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class UserControllerBoundaryImpl implements UserControllerBoundary {

    public final static String BEAN = "userControllerBoundaryImpl";

    @Override
    public UserDto toUserDto(UserVo userVo) {
        return UserDtoMapper.INSTANCE.toUserDto(userVo);
    }

    @Override
    public List<UserDto> toUserDto(List<UserVo> userVo) {
        return UserDtoMapper.INSTANCE.toUserDto(userVo);
    }

    @Override
    public UserVo toUserVo(UserBody userBody) {
        return UserVoMapper.INSTANCE.toUserVo(userBody);
    }

    @Override
    public UserVo toUserVo(String id, UserBody userBody) {
        return UserVoMapper.INSTANCE.toUserVo(id, userBody);
    }

    @Override
    public UserVo toUserVoUpdate(UserBody userBody, UserVo userVo) {
        return UserVoMapper.INSTANCE.toUserVoUpdate(userBody, userVo);
    }
}
