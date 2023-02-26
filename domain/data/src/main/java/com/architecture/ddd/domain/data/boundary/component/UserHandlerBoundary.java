package com.architecture.ddd.domain.data.boundary.component;

import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.MappingTarget;

public interface UserHandlerBoundary {

    UserVo updateUserVo(@MappingTarget UserVo userVoExpected, UserVo userVoCurrent);

    UserVo toUserVoFromId(String id, UserVo userVoCurrent);
}
