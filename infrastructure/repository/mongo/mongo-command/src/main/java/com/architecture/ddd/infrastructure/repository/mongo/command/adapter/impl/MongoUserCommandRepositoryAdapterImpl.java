package com.architecture.ddd.infrastructure.repository.mongo.command.adapter.impl;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.mongo.command.adapter.MongoUserCommandRepositoryAdapter;
import com.architecture.ddd.infrastructure.repository.mongo.command.repository.MongoUserCommandRepository;
import com.architecture.ddd.infrastructure.repository.mongo.mapper.dao.UserDaoMapper;
import com.architecture.ddd.infrastructure.repository.mongo.mapper.vo.UserVoMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component(MongoUserCommandRepositoryAdapterImpl.BEAN)
@RequiredArgsConstructor
public class MongoUserCommandRepositoryAdapterImpl implements MongoUserCommandRepositoryAdapter {

    public static final String BEAN = "mongoUserCommandRepositoryAdapterImpl";

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
