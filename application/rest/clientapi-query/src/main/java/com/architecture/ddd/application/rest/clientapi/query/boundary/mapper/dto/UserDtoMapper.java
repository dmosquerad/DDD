package com.architecture.ddd.application.rest.clientapi.query.boundary.mapper.dto;

import com.architecture.ddd.application.rest.clientapi.query.dto.UserDto;
import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserDtoMapper {

    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    @Mapping(target = "attribute", source = "userVo")
    @Mapping(target = "links", ignore = true)
    UserDto toUserDto(UserVo userVo);

    List<UserDto> toUserDto(List<UserVo> userVo);
}
