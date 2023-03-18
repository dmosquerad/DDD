package com.architecture.ddd.infrastructure.repository.jpa.command.adapter.impl;

import com.architecture.ddd.domain.commandeventhandler.mapper.event.UserEventMapper;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.jpa.command.adapter.JpaUserRepositoryCommandAdapter;
import com.architecture.ddd.infrastructure.repository.jpa.command.repository.JpaUserCommandRepository;
import com.architecture.ddd.infrastructure.repository.jpa.mapper.dao.UserDaoMapper;
import com.architecture.ddd.infrastructure.repository.jpa.mapper.vo.UserVoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component(JpaUserRepositoryCommandAdapterImpl.BEAN)
@RequiredArgsConstructor
public class JpaUserRepositoryCommandAdapterImpl implements JpaUserRepositoryCommandAdapter {

    public static final String BEAN = "jpaUserRepositoryCommandAdapterImpl";

    @NonNull
    private final JpaUserCommandRepository jpaUserCommandRepository;

    @NonNull
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public UserVo save(final @NonNull UserVo userVo) {
        UserVo userVoActual = UserVoMapper.INSTANCE.toUserVo(this.jpaUserCommandRepository.save(UserDaoMapper.INSTANCE.toUserDao(userVo)));

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserSaveEvent(userVoActual));

        return userVoActual;
    }

    @Override
    public UserVo delete(final @NonNull UserVo userVo) {
        this.jpaUserCommandRepository.delete(UserDaoMapper.INSTANCE.toUserDao(userVo));

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserDeleteEvent(userVo));

        return userVo;
    }
}
