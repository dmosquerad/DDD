package com.architecture.ddd.domain.service.microservice.service.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.component.JpaUserRepositoryCommandBoundary;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.component.JpaUserRepositoryQueryBoundary;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.component.impl.JpaUserRepositoryCommandBoundaryImpl;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.component.impl.JpaUserRepositoryQueryBoundaryImpl;
import com.architecture.ddd.infrastructure.repository.mongo.boundary.component.MongoUserQueryRepositoryBoundary;
import com.architecture.ddd.infrastructure.repository.mongo.boundary.component.impl.MongoUserQueryRepositoryBoundaryImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(UserServiceImpl.BEAN)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final static String BEAN = "userServiceImpl";

    @NonNull
    @Qualifier(JpaUserRepositoryQueryBoundaryImpl.BEAN)
    JpaUserRepositoryQueryBoundary jpaUserRepositoryQueryBoundary;

    @NonNull
    @Qualifier(JpaUserRepositoryCommandBoundaryImpl.BEAN)
    JpaUserRepositoryCommandBoundary jpaUserRepositoryCommandBoundary;

    @NonNull
    @Qualifier(MongoUserQueryRepositoryBoundaryImpl.BEAN)
    MongoUserQueryRepositoryBoundary mongoUserQueryRepositoryBoundary;

    @Override
    public UserVo getFistUser() {
        return this.jpaUserRepositoryQueryBoundary.findFirst();
    }

    @Override
    public List<UserVo> getUserAll() {
        return this.jpaUserRepositoryQueryBoundary.findAll();
    }

    @Override
    public UserVo getUserById(String id) {
        return this.jpaUserRepositoryQueryBoundary.findById(Long.valueOf(id));
    }

    @Override
    public UserVo saveUser(UserVo userVo) {
        return this.jpaUserRepositoryCommandBoundary.save(userVo);
    }

    @Override
    public UserVo updateUser(UserVo userVo) {
        return this.jpaUserRepositoryCommandBoundary.save(userVo);
    }

    @Override
    public UserVo deleteUser(UserVo userVo) {
        return this.jpaUserRepositoryCommandBoundary.delete(userVo);
    }

}
