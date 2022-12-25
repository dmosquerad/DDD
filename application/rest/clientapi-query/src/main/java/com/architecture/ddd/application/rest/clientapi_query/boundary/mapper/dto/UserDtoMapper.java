package com.architecture.ddd.application.rest.clientapi_query.boundary.mapper.dto;

import com.architecture.ddd.application.rest.clientapi_query.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    @Mapping(target = "attribute.email", source = "email")
    @Mapping(target = "attribute.name", source = "name")
    @Mapping(target = "attribute.role", source = "role")
    @Mapping(target = "attribute.documentType", source = "documentType")
    @Mapping(target = "links", ignore = true)
    UserDto toUserDto(UserVo userVo);

    List<UserDto> toUserDto(List<UserVo> userVo);
}
