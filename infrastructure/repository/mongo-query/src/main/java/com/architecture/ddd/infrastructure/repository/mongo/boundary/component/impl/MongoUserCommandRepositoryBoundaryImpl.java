package com.architecture.ddd.infrastructure.repository.mongo.boundary.component.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.mongo.boundary.component.MongoUserCommandRepositoryBoundary;
import com.architecture.ddd.infrastructure.repository.mongo.boundary.mapper.dao.UserDaoMapper;
import com.architecture.ddd.infrastructure.repository.mongo.boundary.mapper.vo.UserVoMapper;
import com.architecture.ddd.infrastructure.repository.mongo.repository.MongoUserCommandRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(MongoUserCommandRepositoryBoundaryImpl.BEAN)
@RequiredArgsConstructor
public class MongoUserCommandRepositoryBoundaryImpl implements MongoUserCommandRepositoryBoundary {

    public final static String BEAN = "mongoUserCommandRepositoryBoundaryImpl";

    @NonNull
    MongoUserCommandRepository mongoUserCommandRepository;

    @Override
    public UserVo save(@NonNull final UserVo userVo) {
        return UserVoMapper.INSTANCE.toUserVo(this.mongoUserCommandRepository.save(UserDaoMapper.INSTANCE.toUserDao(userVo)));
    }

    @Override
    public UserVo delete(@NonNull final UserVo userVo) {
        this.mongoUserCommandRepository.delete(UserDaoMapper.INSTANCE.toUserDao(userVo));
        return userVo;
    }
}
