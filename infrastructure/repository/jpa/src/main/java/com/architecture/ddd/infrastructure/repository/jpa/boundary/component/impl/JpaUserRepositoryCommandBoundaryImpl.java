package com.architecture.ddd.infrastructure.repository.jpa.boundary.component.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.component.JpaUserRepositoryCommandBoundary;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.mapper.dao.UserDaoMapper;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.mapper.vo.UserVoMapper;
import com.architecture.ddd.infrastructure.repository.jpa.repository.JpaUserCommandRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(JpaUserRepositoryCommandBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class JpaUserRepositoryCommandBoundaryImpl implements JpaUserRepositoryCommandBoundary {

    public final static String BEAN = "jpaUserRepositoryCommandBoundaryImpl";

    @NonNull
    JpaUserCommandRepository jpaUserCommandRepository;

    @Override
    public UserVo save(UserVo userVo) {
        return UserVoMapper.INSTANCE.toUserVo(this.jpaUserCommandRepository.save(UserDaoMapper.INSTANCE.toUserDao(userVo)));
    }

    @Override
    public UserVo delete(UserVo userVo) {
        this.jpaUserCommandRepository.delete(UserDaoMapper.INSTANCE.toUserDao(userVo));
        return userVo;
    }
}
