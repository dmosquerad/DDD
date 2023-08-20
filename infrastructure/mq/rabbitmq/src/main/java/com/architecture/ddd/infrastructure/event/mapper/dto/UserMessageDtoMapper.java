package com.architecture.ddd.infrastructure.mapper.dto;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Collection;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMessageDtoMapper {

    UserMessageDtoMapper INSTANCE = Mappers.getMapper(UserMessageDtoMapper.class);

    UserMessageDto toUserMessageDto(UserVo userVo);

    ArrayList<UserMessageDto> toUserMessageDto(Collection<UserVo> userVo);

}