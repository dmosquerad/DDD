package com.architecture.ddd.domain.commandeventhandler.component.impl;

import com.architecture.ddd.domain.commandeventhandler.component.UserCommandEventListener;
import com.architecture.ddd.domain.commandeventhandler.event.UserDeleteEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserSaveEvent;
import com.architecture.ddd.infrastructure.repository.mongo.command.boundary.component.MongoUserCommandRepositoryBoundary;
import com.architecture.ddd.infrastructure.repository.mongo.command.boundary.component.impl.MongoUserCommandRepositoryBoundaryImpl;
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
    @Qualifier(MongoUserCommandRepositoryBoundaryImpl.BEAN)
    private final MongoUserCommandRepositoryBoundary mongoUserCommandRepositoryBoundary;

    @Override
    @TransactionalEventListener(classes = UserSaveEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void handleUserSaveEvent(@NonNull final UserSaveEvent userSaveEvent) {

        this.mongoUserCommandRepositoryBoundary.save(userSaveEvent.getMessage());
    }

    @Override
    @TransactionalEventListener(classes = UserDeleteEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void handleUserDeleteEvent(@NonNull final UserDeleteEvent userDeleteEvent) {

        this.mongoUserCommandRepositoryBoundary.delete(userDeleteEvent.getMessage());
    }

}
