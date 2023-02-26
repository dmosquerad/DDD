package com.architecture.ddd.infrastructure.repository.jpa.command.boundary.component;

import com.architecture.ddd.domain.data.vo.UserVo;

public interface JpaUserRepositoryCommandBoundary {

    UserVo save(UserVo userVo);

    UserVo delete(UserVo userVo);
}
