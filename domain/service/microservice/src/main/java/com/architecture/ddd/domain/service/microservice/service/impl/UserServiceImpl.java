package com.architecture.ddd.domain.service.microservice.service.impl;

import com.architecture.ddd.domain.commandeventhandler.mapper.event.UserEventMapper;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.infrastructure.repository.jpa.command.boundary.component.JpaUserRepositoryCommandBoundary;
import com.architecture.ddd.infrastructure.repository.jpa.command.boundary.component.impl.JpaUserRepositoryCommandBoundaryImpl;
import com.architecture.ddd.infrastructure.repository.mongo.query.boundary.component.MongoUserQueryRepositoryBoundary;
import com.architecture.ddd.infrastructure.repository.mongo.query.boundary.component.impl.MongoUserQueryRepositoryBoundaryImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service(UserServiceImpl.BEAN)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public static final String BEAN = "userServiceImpl";

    @NonNull
    @Qualifier(JpaUserRepositoryCommandBoundaryImpl.BEAN)
    private final JpaUserRepositoryCommandBoundary jpaUserRepositoryCommandBoundary;

    @NonNull
    @Qualifier(MongoUserQueryRepositoryBoundaryImpl.BEAN)
    private final MongoUserQueryRepositoryBoundary mongoUserQueryRepositoryBoundary;

    @NonNull
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public UserVo getFistUser() {
        return this.mongoUserQueryRepositoryBoundary.findFirst();
    }

    @Override
    public List<UserVo> getUserAll() {
        return this.mongoUserQueryRepositoryBoundary.findAll();
    }

    @Override
    public UserVo getUserByUuid(@NonNull final UUID uuid) {
        return this.mongoUserQueryRepositoryBoundary.findByUuid(String.valueOf(uuid));
    }

    @Override
    public UserVo saveUser(@NonNull final UserVo userVo) {
        UserVo userVoActual = this.jpaUserRepositoryCommandBoundary.save(userVo);

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserSaveEvent(userVoActual));

        return userVoActual;
    }

    @Override
    public UserVo deleteUser(@NonNull final UserVo userVo) {
        UserVo userVoActual = this.jpaUserRepositoryCommandBoundary.delete(userVo);

        this.applicationEventPublisher.publishEvent(UserEventMapper.INSTANCE.toUserDeleteEvent(userVoActual));

        return userVoActual;
    }
}
