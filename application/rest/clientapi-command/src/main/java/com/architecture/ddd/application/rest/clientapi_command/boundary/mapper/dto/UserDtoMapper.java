package com.architecture.ddd.application.rest.clientapi_command.boundary.mapper.dto;

import com.architecture.ddd.application.rest.clientapi_command.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    @Mapping(target = "attribute", ignore = true)
    @Mapping(target = "attribute.email", source = "email")
    @Mapping(target = "attribute.name", source = "name")
    @Mapping(target = "attribute.role", source = "role")
    @Mapping(target = "attribute.documentType", source = "documentType")
    @Mapping(target = "links", ignore = true)
    UserDto toUserDto(UserVo userVo);

}
