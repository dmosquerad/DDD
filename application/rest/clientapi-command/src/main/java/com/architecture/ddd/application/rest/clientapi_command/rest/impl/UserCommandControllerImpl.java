package com.architecture.ddd.application.rest.clientapi_command.rest.impl;

import com.architecture.ddd.application.rest.clientapi_command.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi_command.rest.UsersApi;
import com.architecture.ddd.application.rest.clientapi_command.service.UserCommandServiceController;
import com.architecture.ddd.application.rest.clientapi_command.service.impl.UserServiceControllerImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController(UserCommandControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserCommandControllerImpl implements UsersApi {

    public final static String BEAN = "userControllerImpl";

    @NonNull
    @Qualifier(UserServiceControllerImpl.BEAN)
    private final UserCommandServiceController userCommandServiceController;

    @Override
    public ResponseEntity<ResponseUser> createUser(UserBody userBody) {
        return this.userCommandServiceController.createUser(userBody);
    }

    @Override
    public ResponseEntity<ResponseUser> deleteUserByUuid(UUID userUuid) {
        return this.userCommandServiceController.deleteUserByUuid(userUuid);
    }

    @Override
    public ResponseEntity<ResponseUser> putUserByUuid(UUID userUuid, UserBody userBody) {
        return this.userCommandServiceController.putUserByUuid(userUuid, userBody);
    }

    @Override
    public ResponseEntity<ResponseUser> patchUserByUuid(UUID userUuid, UserBody userBody) {
        return this.userCommandServiceController.patchUserByUuid(userUuid, userBody);
    }
}
