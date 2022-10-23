package com.architecture.ddd.infrastructure.repository.jpa.repository;

import com.architecture.ddd.infrastructure.repository.jpa.dao.UserDao;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface JpaUserQueryRepository extends PagingAndSortingRepository<UserDao, Long> {

    @Override
    Optional<UserDao> findById(Long id);

    @Override
    List<UserDao> findAll();
}
