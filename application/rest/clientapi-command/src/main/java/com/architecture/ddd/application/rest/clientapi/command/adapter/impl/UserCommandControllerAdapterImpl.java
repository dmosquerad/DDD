package com.architecture.ddd.application.rest.clientapi.command.adapter.impl;

import com.architecture.ddd.application.rest.clientapi.command.adapter.UserCommandControllerAdapter;
import com.architecture.ddd.application.rest.clientapi.command.mapper.vo.UserVoMapper;
import com.architecture.ddd.domain.data.vo.UserVo;
import com.architecture.ddd.infrastructure.event.producer.UserEventProducer;
import com.architecture.ddd.infrastructure.event.producer.impl.UserEventProducerImpl;
import com.architecture.ddd.infrastructure.validation.util.UserValidationUtil;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.UUID;

@Component(UserCommandControllerAdapterImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandControllerAdapterImpl implements UserCommandControllerAdapter {

    public static final String BEAN = "userCommandControllerAdapterImpl";

    @NonNull
    @Qualifier(UserEventProducerImpl.BEAN)
    private final UserEventProducer userEventProducer;

    @Override
    @Transactional
    public UserVo createUser(@NonNull final UserVo userVo) {
        return this.userEventProducer.senderAndReceiveCreate(userVo);
    }

    @Override
    @Transactional
    public UserVo deleteUserByUuid(@NonNull final UUID uuid) {
        final UserVo existUserVo = this.userEventProducer.senderAndReceiveQueryByUuid(uuid);

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return this.userEventProducer.senderAndReceiveDelete(existUserVo);
    }

    @Override
    @Transactional
    public UserVo createOrUpdateUser(@NonNull final UserVo userVo) {
        final UserVo existUserVo = this.userEventProducer.senderAndReceiveQueryByUuid(userVo.getUuid());

        UserVo userVoCurrent = UserVoMapper.INSTANCE.toUserVoFromId(existUserVo.getId(), userVo);

        return this.userEventProducer.senderAndReceiveCreate(userVoCurrent);
    }

    @Override
    @Transactional
    public UserVo updateUser(@NonNull final UserVo userVo) {
        final UserVo existUserVo = this.userEventProducer.senderAndReceiveQueryByUuid(userVo.getUuid());

        if (Objects.isNull(existUserVo)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        UserVo userVoCurrent = UserValidationUtil.validateUserVoToUpdate(existUserVo, userVo);
        return this.userEventProducer.senderAndReceiveCreate(userVoCurrent);
    }
}
