package com.architecture.ddd.application.rest.clientapi_command.boundary.mapper.vo;

import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserVoMapper {

    UserVoMapper INSTANCE = Mappers.getMapper(UserVoMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", expression = "java(java.util.UUID.randomUUID())")
    UserVo toUserVoInsert(UserBody userBody);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "email", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "role", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "documentType", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserVo toUserVoPatch(@MappingTarget UserVo userVo, UserBody userBody);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    UserVo toUserVoPut(@MappingTarget UserVo userVo, UserBody userBody);

}
