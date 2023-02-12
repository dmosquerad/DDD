package com.architecture.ddd.domain.commandeventhandler.component;

import com.architecture.ddd.domain.commandeventhandler.event.UserDeleteEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPatchEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPostEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPutEvent;
import com.architecture.ddd.domain.data.vo.UserVo;

public interface UserCommandEventListener {

    UserVo handleUserPostEvent(UserPostEvent userPostEvent);

    UserVo handleUserPutEvent(UserPutEvent userPutEvent);

    UserVo handleUserPatchEvent(UserPatchEvent userPatchEvent);

    UserVo handleUserDeleteEvent(UserDeleteEvent userDeleteEvent);
}
