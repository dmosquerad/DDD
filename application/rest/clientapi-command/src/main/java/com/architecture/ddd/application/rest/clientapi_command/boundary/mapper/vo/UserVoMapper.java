package com.architecture.ddd.application.rest.clientapi_command.boundary.mapper.vo;

import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserVoMapper {

    UserVoMapper INSTANCE = Mappers.getMapper(UserVoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", expression = "java(java.util.UUID.randomUUID())")
    UserVo toUserVo(UserBody userBody);

    @Mapping(target = "id", ignore = true)
    UserVo toUserVoFromUserBodyAndUuid(UUID uuid, UserBody userBody);

}
