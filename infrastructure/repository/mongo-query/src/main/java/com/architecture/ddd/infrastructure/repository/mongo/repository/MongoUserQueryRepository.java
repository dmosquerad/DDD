package com.architecture.ddd.infrastructure.repository.mongo.repository;

import com.architecture.ddd.infrastructure.repository.mongo.dao.UserDao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MongoUserQueryRepository extends MongoRepository<UserDao, String> {

    @Override
    Optional<UserDao> findById(String id);

    @Override
    List<UserDao> findAll();
}
