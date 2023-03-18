package com.architecture.ddd.application.rest.clientapi.command.mapper.dto;

import com.architecture.ddd.application.rest.clientapi_command.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    @Mapping(target = "attribute", source = "userVo")
    @Mapping(target = "links", ignore = true)
    UserDto toUserDto(UserVo userVo);
}
