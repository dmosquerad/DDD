package com.architecture.ddd.infrastructure.repository.mongo.repository.custom;

import com.architecture.ddd.infrastructure.repository.mongo.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoCustomUserQueryRepository {

    UserDao findFirstUser();
}
