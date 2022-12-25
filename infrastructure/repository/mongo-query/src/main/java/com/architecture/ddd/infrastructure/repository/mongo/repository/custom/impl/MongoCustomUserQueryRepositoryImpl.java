package com.architecture.ddd.infrastructure.repository.mongo.repository.custom.impl;

import com.architecture.ddd.infrastructure.repository.mongo.dao.UserDao;
import com.architecture.ddd.infrastructure.repository.mongo.repository.MongoUserQueryRepository;
import com.architecture.ddd.infrastructure.repository.mongo.repository.custom.MongoCustomUserQueryRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository(MongoCustomUserQueryRepositoryImpl.BEAN)
@RequiredArgsConstructor
public class MongoCustomUserQueryRepositoryImpl implements MongoCustomUserQueryRepository {

    public final static String BEAN = "MongoCustomUserQueryRepositoryImpl";

    @NonNull
    MongoTemplate mongoTemplate;

    @NonNull
    MongoUserQueryRepository mongoUserQueryRepository;

    @Override
    public UserDao findFirstUser() {
        return this.mongoTemplate.find(null, UserDao.class).stream().filter(Objects::nonNull).findFirst().get();
    }
}
