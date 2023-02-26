package com.architecture.ddd.infrastructure.repository.jpa.command.repository.custom;

import com.architecture.ddd.infrastructure.repository.jpa.data.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCustomUserQueryRepository {

    UserDao findFirstUser();
}
