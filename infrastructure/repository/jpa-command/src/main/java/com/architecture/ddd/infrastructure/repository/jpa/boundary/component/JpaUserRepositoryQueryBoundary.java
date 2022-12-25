package com.architecture.ddd.infrastructure.repository.jpa.boundary.component;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;

public interface JpaUserRepositoryQueryBoundary {

    UserVo findById(Long id);

    UserVo findFirst();

    List<UserVo> findAll();

}
