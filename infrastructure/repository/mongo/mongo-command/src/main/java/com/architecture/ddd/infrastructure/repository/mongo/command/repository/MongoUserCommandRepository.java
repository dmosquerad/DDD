package com.architecture.ddd.infrastructure.repository.mongo.command.repository;

import com.architecture.ddd.infrastructure.repository.mongo.data.dao.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface MongoUserCommandRepository extends CrudRepository<UserDao, String> {

    @Override
    void delete(UserDao userDao);

    @Override
    UserDao save(UserDao userDao);
}
