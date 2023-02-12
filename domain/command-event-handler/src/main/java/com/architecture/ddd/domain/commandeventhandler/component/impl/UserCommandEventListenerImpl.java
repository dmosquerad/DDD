package com.architecture.ddd.domain.commandeventhandler.component.impl;

import com.architecture.ddd.domain.commandeventhandler.component.UserCommandEventListener;
import com.architecture.ddd.domain.commandeventhandler.event.UserDeleteEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPatchEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPostEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserPutEvent;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.domain.service.microservice.service.UserService;
import com.architecture.ddd.domain.service.microservice.service.impl.UserServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component(UserCommandEventListenerImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandEventListenerImpl implements UserCommandEventListener {

    public final static String BEAN = "UserCommandEventListenerImpl";

    @NonNull
    @Qualifier(UserServiceImpl.BEAN)
    private final UserService userService;

    @Override
    @TransactionalEventListener(classes = UserPostEvent.class, phase = TransactionPhase.BEFORE_COMMIT)
    public UserVo handleUserPostEvent(@NonNull final UserPostEvent userPostEvent) {
        return this.userService.saveUser(userPostEvent.getMessage());
    }

    @Override
    @TransactionalEventListener(classes = UserPutEvent.class, phase = TransactionPhase.BEFORE_COMMIT)
    public UserVo handleUserPutEvent(@NonNull final UserPutEvent userPutEvent) {
        return this.userService.saveUser(userPutEvent.getMessage());
    }

    @Override
    @TransactionalEventListener(classes = UserPatchEvent.class, phase = TransactionPhase.BEFORE_COMMIT)
    public UserVo handleUserPatchEvent(@NonNull final UserPatchEvent userPatchEvent) {
        return this.userService.saveUser(userPatchEvent.getMessage());
    }

    @Override
    @TransactionalEventListener(classes = UserDeleteEvent.class, phase = TransactionPhase.BEFORE_COMMIT)
    public UserVo handleUserDeleteEvent(@NonNull final UserDeleteEvent userDeleteEvent) {
        return this.userService.deleteUser(userDeleteEvent.getMessage());
    }

}
