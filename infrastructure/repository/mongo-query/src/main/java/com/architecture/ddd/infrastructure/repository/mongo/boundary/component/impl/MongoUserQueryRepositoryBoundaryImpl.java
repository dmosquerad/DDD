package com.architecture.ddd.infrastructure.repository.mongo.boundary.component.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.mongo.boundary.component.MongoUserQueryRepositoryBoundary;
import com.architecture.ddd.infrastructure.repository.mongo.boundary.mapper.vo.UserVoMapper;
import com.architecture.ddd.infrastructure.repository.mongo.repository.MongoUserQueryRepository;
import com.architecture.ddd.infrastructure.repository.mongo.repository.custom.MongoCustomUserQueryRepository;
import com.architecture.ddd.infrastructure.repository.mongo.repository.custom.impl.MongoCustomUserQueryRepositoryImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(MongoUserQueryRepositoryBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class MongoUserQueryRepositoryBoundaryImpl implements MongoUserQueryRepositoryBoundary {

    public final static String BEAN = "mongoUserQueryRepositoryBoundaryImpl";

    @NonNull
    MongoUserQueryRepository mongoUserQueryRepository;

    @NonNull
    @Qualifier(MongoCustomUserQueryRepositoryImpl.BEAN)
    MongoCustomUserQueryRepository mongoCustomUserReadDaoRepository;

    @Override
    public UserVo findFirst() {
        return UserVoMapper.INSTANCE.toUserVo(this.mongoCustomUserReadDaoRepository.findFirstUser());
    }
    
    @Override
    public List<UserVo> findAll() {
        return UserVoMapper.INSTANCE.toUserVo(this.mongoUserQueryRepository.findAll());
    }
}
