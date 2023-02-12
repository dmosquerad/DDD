package com.architecture.ddd.infrastructure.repository.jpa.boundary.component.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.component.JpaUserRepositoryQueryBoundary;
import com.architecture.ddd.infrastructure.repository.jpa.boundary.mapper.vo.UserVoMapper;
import com.architecture.ddd.infrastructure.repository.jpa.repository.JpaUserQueryRepository;
import com.architecture.ddd.infrastructure.repository.jpa.repository.custom.JpaCustomUserQueryRepository;
import com.architecture.ddd.infrastructure.repository.jpa.repository.custom.impl.JpaCustomUserQueryRepositoryImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component(JpaUserRepositoryQueryBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class JpaUserRepositoryQueryBoundaryImpl implements JpaUserRepositoryQueryBoundary {

    public final static String BEAN = "jpaUserRepositoryQueryBoundaryImpl";

    @NonNull
    JpaUserQueryRepository jpaUserQueryRepository;

    @NonNull
    @Qualifier(JpaCustomUserQueryRepositoryImpl.BEAN)
    JpaCustomUserQueryRepository jpaCustomUserQueryRepository;

    @Override
    public UserVo findByUuid(UUID uuid) {
        return UserVoMapper.INSTANCE.toUserVo(this.jpaUserQueryRepository.findByUuid(uuid));
    }

    @Override
    public UserVo findFirst() {
        return UserVoMapper.INSTANCE.toUserVo(this.jpaCustomUserQueryRepository.findFirstUser());
    }

    @Override
    public List<UserVo> findAll() {
        return UserVoMapper.INSTANCE.toUserVo(this.jpaUserQueryRepository.findAll());
    }

}
