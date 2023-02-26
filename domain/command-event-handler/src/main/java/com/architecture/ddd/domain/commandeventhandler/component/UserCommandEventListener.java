package com.architecture.ddd.domain.commandeventhandler.component;

import com.architecture.ddd.domain.commandeventhandler.event.UserDeleteEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserSaveEvent;

public interface UserCommandEventListener {

    void handleUserSaveEvent(UserSaveEvent userSaveEvent);

    void handleUserDeleteEvent(UserDeleteEvent userDeleteEvent);
}
