package com.architecture.ddd.infrastructure.event.producer;


import com.architecture.ddd.domain.data.vo.UserVo;

import java.util.List;
import java.util.UUID;

public interface UserEventProducer {

    UserVo senderAndReceiveCreate(UserVo userVo);

    UserVo senderAndReceiveDelete(UserVo userVo);

    UserVo senderAndReceiveQueryByUuid(UUID uuid);

    List<UserVo> senderAndReceiveQueryAll();
}
