package com.architecture.ddd.infrastructure.repository.mongo.data.mapper.vo;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.mongo.data.dao.UserDao;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserVoMapper {

    UserVoMapper INSTANCE = Mappers.getMapper(UserVoMapper.class);

    UserVo toUserVo(UserDao userDao);

    List<UserVo> toUserVo(Collection<UserDao> userDao);
}
