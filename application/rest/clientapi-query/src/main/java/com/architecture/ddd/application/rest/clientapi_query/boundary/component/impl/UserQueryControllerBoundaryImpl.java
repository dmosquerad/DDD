package com.architecture.ddd.application.rest.clientapi_query.boundary.component.impl;

import com.architecture.ddd.application.rest.clientapi_query.boundary.component.UserQueryControllerBoundary;
import com.architecture.ddd.application.rest.clientapi_query.boundary.mapper.dto.UserDtoMapper;
import com.architecture.ddd.application.rest.clientapi_query.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(UserQueryControllerBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class UserQueryControllerBoundaryImpl implements UserQueryControllerBoundary {

    public final static String BEAN = "userControllerBoundaryImpl";

    @Override
    public UserDto toUserDto(UserVo userVo) {
        return UserDtoMapper.INSTANCE.toUserDto(userVo);
    }

    @Override
    public List<UserDto> toUserDto(List<UserVo> userVo) {
        return UserDtoMapper.INSTANCE.toUserDto(userVo);
    }
}
