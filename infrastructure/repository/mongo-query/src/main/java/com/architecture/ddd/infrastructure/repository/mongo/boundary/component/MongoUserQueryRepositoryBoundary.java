package com.architecture.ddd.infrastructure.repository.mongo.boundary.component;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;

public interface MongoUserQueryRepositoryBoundary {

    UserVo findById(String id);

    UserVo findFirst();

    List<UserVo> findAll();
}
