package com.architecture.ddd.infrastructure.repository.mongo.boundary.mapper.dao;

import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.repository.mongo.dao.UserDao;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserDaoMapper {

    UserDaoMapper INSTANCE = Mappers.getMapper(UserDaoMapper.class);
    
    UserDao toUserDao(UserVo userVo);

}
