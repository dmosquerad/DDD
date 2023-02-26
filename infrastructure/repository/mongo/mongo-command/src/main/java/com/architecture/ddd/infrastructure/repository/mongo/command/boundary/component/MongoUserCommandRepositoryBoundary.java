package com.architecture.ddd.infrastructure.repository.mongo.command.boundary.component;

import com.architecture.ddd.domain.data.vo.UserVo;

public interface MongoUserCommandRepositoryBoundary {

    UserVo save(UserVo userVo);

    UserVo delete(UserVo userVo);
}
