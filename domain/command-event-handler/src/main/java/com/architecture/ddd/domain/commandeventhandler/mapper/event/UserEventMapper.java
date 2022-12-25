package com.architecture.ddd.domain.commandeventhandler.mapper.event;

import com.architecture.ddd.domain.commandeventhandler.event.UserDeleteEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPatchEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPostEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPutEvent;
import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserEventMapper {

    UserEventMapper INSTANCE = Mappers.getMapper(UserEventMapper.class);

    @Mapping(source = "userVo", target = "message")
    UserPostEvent toUserCreateEvent(UserVo userVo);

    @Mapping(source = "userVo", target = "message")
    UserDeleteEvent toUserDeleteEvent(UserVo userVo);

    @Mapping(source = "userVo", target = "message")
    UserPutEvent toUserPutEvent(UserVo userVo);

    @Mapping(source = "userVo", target = "message")
    UserPatchEvent toUserPatchEvent(UserVo userVo);
}
