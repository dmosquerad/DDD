package com.architecture.ddd.application.rest.clientapi.query.boundary.component.impl;

import com.architecture.ddd.application.rest.clientapi.query.boundary.component.UserQueryControllerBoundary;
import com.architecture.ddd.application.rest.clientapi.query.boundary.mapper.dto.UserDtoMapper;
import com.architecture.ddd.application.rest.clientapi.query.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(UserQueryControllerBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class UserQueryControllerBoundaryImpl implements UserQueryControllerBoundary {

    public final static String BEAN = "userQueryControllerBoundaryImpl";

    @Override
    public UserDto toUserDto(@NonNull final UserVo userVo) {
        return UserDtoMapper.INSTANCE.toUserDto(userVo);
    }

    @Override
    public List<UserDto> toUserDto(@NonNull final List<UserVo> userVo) {
        return UserDtoMapper.INSTANCE.toUserDto(userVo);
    }
}