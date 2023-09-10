package com.architecture.ddd.application.rest.clientapi.query.adapter.impl;

import com.architecture.ddd.application.rest.clientapi.query.adapter.UserQueryControllerAdapter;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.event.producer.UserEventProducer;
import com.architecture.ddd.infrastructure.event.producer.impl.UserEventProducerImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service(UserQueryControllerAdapterImpl.BEAN)
@RequiredArgsConstructor
public class UserQueryControllerAdapterImpl implements UserQueryControllerAdapter {

    public static final String BEAN = "userQueryControllerAdapterImpl";

    @NonNull
    @Qualifier(UserEventProducerImpl.BEAN)
    private final UserEventProducer userEventProducer;

    @Override
    public List<UserVo> getAllUsers() {
        return this.userEventProducer.senderAndReceiveQueryAll();
    }

    @Override
    public UserVo getUserByUuid(@NonNull final UUID uuid) {
        return this.userEventProducer.senderAndReceiveQueryByUuid(uuid);
    }

}
