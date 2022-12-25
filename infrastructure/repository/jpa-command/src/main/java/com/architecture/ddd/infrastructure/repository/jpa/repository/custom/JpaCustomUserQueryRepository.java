package com.architecture.ddd.infrastructure.repository.jpa.repository.custom;

import com.architecture.ddd.infrastructure.repository.jpa.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomUserQueryRepository {

    UserDao findFirstUser();
}
