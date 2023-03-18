package com.architecture.ddd.infrastructure.repository.mongo.query.adapter.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.mongo.mapper.vo.UserVoMapper;
import com.architecture.ddd.infrastructure.repository.mongo.query.adapter.MongoUserQueryRepositoryAdapter;
import com.architecture.ddd.infrastructure.repository.mongo.query.repository.MongoUserQueryRepository;
import com.architecture.ddd.infrastructure.repository.mongo.query.repository.custom.MongoCustomUserQueryRepository;
import com.architecture.ddd.infrastructure.repository.mongo.query.repository.custom.impl.MongoCustomUserQueryRepositoryImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(MongoUserQueryRepositoryAdapterImpl.BEAN)
@RequiredArgsConstructor
public class MongoUserQueryRepositoryAdapterImpl implements MongoUserQueryRepositoryAdapter {

    public static final String BEAN = "mongoUserQueryRepositoryAdapterImpl";

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

    @Override
    public UserVo findByUuid(String Uuid) {
        return UserVoMapper.INSTANCE.toUserVo(this.mongoUserQueryRepository.findByUuid(Uuid));
    }
}
