package com.architecture.ddd.domain.service.microservice.service.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.infrastructure.repository.jpa.command.adapter.JpaUserRepositoryCommandAdapter;
import com.architecture.ddd.infrastructure.repository.jpa.command.adapter.impl.JpaUserRepositoryCommandAdapterImpl;
import com.architecture.ddd.infrastructure.repository.mongo.query.adapter.MongoUserQueryRepositoryAdapter;
import com.architecture.ddd.infrastructure.repository.mongo.query.adapter.impl.MongoUserQueryRepositoryAdapterImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service(UserServiceImpl.BEAN)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public static final String BEAN = "userServiceImpl";

    @NonNull
    @Qualifier(JpaUserRepositoryCommandAdapterImpl.BEAN)
    private final JpaUserRepositoryCommandAdapter jpaUserRepositoryCommandAdapter;

    @NonNull
    @Qualifier(MongoUserQueryRepositoryAdapterImpl.BEAN)
    private final MongoUserQueryRepositoryAdapter mongoUserQueryRepositoryAdapter;

    @Override
    public UserVo getFistUser() {
        return this.mongoUserQueryRepositoryAdapter.findFirst();
    }

    @Override
    public List<UserVo> getUserAll() {
        return this.mongoUserQueryRepositoryAdapter.findAll();
    }

    @Override
    public UserVo getUserByUuid(@NonNull final UUID uuid) {
        return this.mongoUserQueryRepositoryAdapter.findByUuid(String.valueOf(uuid));
    }

    @Override
    public UserVo saveUser(@NonNull final UserVo userVo) {
        return this.jpaUserRepositoryCommandAdapter.save(userVo);
    }

    @Override
    public UserVo deleteUser(@NonNull final UserVo userVo) {
        return this.jpaUserRepositoryCommandAdapter.delete(userVo);
    }
}
