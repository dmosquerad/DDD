package com.architecture.ddd.domain.data.boundary.component.impl;

import com.architecture.ddd.domain.data.boundary.component.UserHandlerBoundary;
import com.architecture.ddd.domain.data.boundary.mapper.UserVoMapper;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component(UserHandlerHandlerBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class UserHandlerHandlerBoundaryImpl implements UserHandlerBoundary {

    public final static String BEAN = "userHandlerBoundaryImpl";

    @Override
    public UserVo updateUserVo(UserVo userVoExpected, UserVo userVoCurrent) {
        return UserVoMapper.INSTANCE.updateUserVo(userVoExpected, userVoCurrent);
    }

    @Override
    public UserVo toUserVoFromId(String id, UserVo userVoCurrent) {
        return UserVoMapper.INSTANCE.toUserVoFromId(id, userVoCurrent);
    }
}
