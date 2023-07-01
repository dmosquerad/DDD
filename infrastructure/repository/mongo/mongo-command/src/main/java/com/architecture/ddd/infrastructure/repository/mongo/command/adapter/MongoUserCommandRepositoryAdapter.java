package com.architecture.ddd.infrastructure.repository.mongo.command.adapter;

import com.architecture.ddd.domain.data.vo.UserVo;

public interface MongoUserCommandRepositoryAdapter {

    UserVo save(UserVo userVo);

    UserVo delete(UserVo userVo);
}
