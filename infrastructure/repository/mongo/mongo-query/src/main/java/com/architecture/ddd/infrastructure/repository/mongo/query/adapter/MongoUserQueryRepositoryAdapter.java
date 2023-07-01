package com.architecture.ddd.infrastructure.repository.mongo.query.adapter;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;

public interface MongoUserQueryRepositoryAdapter {

    UserVo findFirst();

    List<UserVo> findAll();

    UserVo findByUuid(String Uuid);
}
