package com.architecture.ddd.infrastructure.repository.mongo.query.repository.custom;

import com.architecture.ddd.infrastructure.repository.mongo.data.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoCustomUserQueryRepository {

    UserDao findFirstUser();
}
