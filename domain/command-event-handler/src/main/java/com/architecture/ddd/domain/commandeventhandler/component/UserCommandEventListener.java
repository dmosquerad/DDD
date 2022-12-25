package com.architecture.ddd.domain.commandeventhandler.component;

import com.architecture.ddd.domain.commandeventhandler.event.UserDeleteEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPatchEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPostEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPutEvent;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.NonNull;

public interface UserCommandEventListener {

    UserVo handleUserPostEvent(@NonNull UserPostEvent userPostEvent);

    UserVo handleUserPutEvent(@NonNull UserPutEvent userPutEvent);

    UserVo handleUserPatchEvent(@NonNull UserPatchEvent userPatchEvent);

    UserVo handleUserDeleteEvent(@NonNull UserDeleteEvent userDeleteEvent);
}
