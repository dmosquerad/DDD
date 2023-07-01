package com.architecture.ddd.infrastructure.repository.jpa.command.adapter;

import com.architecture.ddd.domain.data.vo.UserVo;

public interface JpaUserRepositoryCommandAdapter {

    UserVo save(UserVo userVo);

    UserVo delete(UserVo userVo);
}
