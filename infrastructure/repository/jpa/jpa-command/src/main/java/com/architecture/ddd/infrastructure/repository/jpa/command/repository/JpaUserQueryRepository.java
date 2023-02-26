package com.architecture.ddd.infrastructure.repository.jpa.command.repository;

import com.architecture.ddd.infrastructure.repository.jpa.data.dao.UserDao;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.UUID;

public interface JpaUserQueryRepository extends PagingAndSortingRepository<UserDao, Long> {

    UserDao findByUuid(UUID id);

    @Override
    List<UserDao> findAll();
}
