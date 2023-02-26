package com.architecture.ddd.infrastructure.repository.mongo.query.repository;

import com.architecture.ddd.infrastructure.repository.mongo.data.dao.UserDao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoUserQueryRepository extends MongoRepository<UserDao, String> {

    @Override
    List<UserDao> findAll();

    UserDao findByUuid(String Uuid);
}
