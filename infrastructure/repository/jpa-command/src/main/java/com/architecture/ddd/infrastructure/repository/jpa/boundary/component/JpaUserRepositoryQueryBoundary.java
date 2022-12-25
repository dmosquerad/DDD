package com.architecture.ddd.infrastructure.repository.jpa.boundary.component;

import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;
import java.util.UUID;

public interface JpaUserRepositoryQueryBoundary {

    UserVo findById(Long id);

    UserVo findByUuid(UUID uuid);

    UserVo findFirst();

    List<UserVo> findAll();

}
