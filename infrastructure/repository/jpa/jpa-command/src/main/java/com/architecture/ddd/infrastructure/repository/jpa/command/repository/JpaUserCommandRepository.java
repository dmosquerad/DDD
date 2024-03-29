package com.architecture.ddd.infrastructure.repository.jpa.command.repository;

import com.architecture.ddd.infrastructure.repository.jpa.data.dao.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface JpaUserCommandRepository extends CrudRepository<UserDao, Long> {

    @Override
    void delete(UserDao userDao);

    @Override
    UserDao save(UserDao userDao);
}
