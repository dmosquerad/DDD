package com.architecture.ddd.infrastructure.repository.mongo.query.boundary.component;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;

public interface MongoUserQueryRepositoryBoundary {

    UserVo findFirst();

    List<UserVo> findAll();

    UserVo findByUuid(String Uuid);
}
