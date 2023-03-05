package com.architecture.ddd.infrastructure.repository.jpa.command.boundary.component.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.jpa.command.boundary.component.JpaUserRepositoryCommandBoundary;
import com.architecture.ddd.infrastructure.repository.jpa.command.repository.JpaUserCommandRepository;
import com.architecture.ddd.infrastructure.repository.jpa.data.boundary.mapper.dao.UserDaoMapper;
import com.architecture.ddd.infrastructure.repository.jpa.data.boundary.mapper.vo.UserVoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(JpaUserRepositoryCommandBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class JpaUserRepositoryCommandBoundaryImpl implements JpaUserRepositoryCommandBoundary {

    public static final String BEAN = "jpaUserRepositoryCommandBoundaryImpl";

    @NonNull
    JpaUserCommandRepository jpaUserCommandRepository;

    @Override
    public UserVo save(final @NonNull UserVo userVo) {
        return UserVoMapper.INSTANCE.toUserVo(this.jpaUserCommandRepository.save(UserDaoMapper.INSTANCE.toUserDao(userVo)));
    }

    @Override
    public UserVo delete(final @NonNull UserVo userVo) {
        this.jpaUserCommandRepository.delete(UserDaoMapper.INSTANCE.toUserDao(userVo));
        return userVo;
    }
}
