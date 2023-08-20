package com.architecture.ddd.infrastructure.mapper.vo;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.data.message.dto.UserMessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserVoMapper {

    UserVoMapper INSTANCE = Mappers.getMapper(UserVoMapper.class);

    UserVo toUserVo(UserMessageDto userMessageDto);

    List<UserVo> toUserVo(Collection<UserMessageDto> userMessageDto);

}
