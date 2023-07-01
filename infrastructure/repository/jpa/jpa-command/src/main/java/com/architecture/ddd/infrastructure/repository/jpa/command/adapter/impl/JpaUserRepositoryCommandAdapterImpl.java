package com.architecture.ddd.infrastructure.repository.jpa.command.adapter.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.jpa.command.adapter.JpaUserRepositoryCommandAdapter;
import com.architecture.ddd.infrastructure.repository.jpa.command.repository.JpaUserCommandRepository;
import com.architecture.ddd.infrastructure.repository.jpa.data.mapper.dao.UserDaoMapper;
import com.architecture.ddd.infrastructure.repository.jpa.data.mapper.vo.UserVoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(JpaUserRepositoryCommandAdapterImpl.BEAN)
@RequiredArgsConstructor
public class JpaUserRepositoryCommandAdapterImpl implements JpaUserRepositoryCommandAdapter {

    public static final String BEAN = "jpaUserRepositoryCommandAdapterImpl";

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
