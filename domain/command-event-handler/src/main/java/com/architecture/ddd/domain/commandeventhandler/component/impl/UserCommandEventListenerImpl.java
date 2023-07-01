package com.architecture.ddd.domain.commandeventhandler.component.impl;

import com.architecture.ddd.domain.commandeventhandler.component.UserCommandEventListener;
import com.architecture.ddd.domain.commandeventhandler.event.UserDeleteEvent;
import com.architecture.ddd.domain.commandeventhandler.event.UserSaveEvent;
import com.architecture.ddd.infrastructure.repository.mongo.command.adapter.MongoUserCommandRepositoryAdapter;
import com.architecture.ddd.infrastructure.repository.mongo.command.adapter.impl.MongoUserCommandRepositoryAdapterImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component(UserCommandEventListenerImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandEventListenerImpl implements UserCommandEventListener {

    public static final String BEAN = "UserCommandEventListenerImpl";

    @NonNull
    @Qualifier(MongoUserCommandRepositoryAdapterImpl.BEAN)
    private final MongoUserCommandRepositoryAdapter mongoUserCommandRepositoryAdapter;

    @Override
    @TransactionalEventListener(classes = UserSaveEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void handleUserSaveEvent(@NonNull final UserSaveEvent userSaveEvent) {

        this.mongoUserCommandRepositoryAdapter.save(userSaveEvent.getMessage());
    }

    @Override
    @TransactionalEventListener(classes = UserDeleteEvent.class, phase = TransactionPhase.AFTER_COMMIT)
    public void handleUserDeleteEvent(@NonNull final UserDeleteEvent userDeleteEvent) {

        this.mongoUserCommandRepositoryAdapter.delete(userDeleteEvent.getMessage());
    }

}
