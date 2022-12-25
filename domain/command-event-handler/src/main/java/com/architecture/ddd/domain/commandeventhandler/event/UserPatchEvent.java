package com.architecture.ddd.domain.commandeventhandler.event;

import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserPatchEvent {

    UserVo message;
}
