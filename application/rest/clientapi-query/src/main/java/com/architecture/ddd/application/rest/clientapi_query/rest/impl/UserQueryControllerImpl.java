package com.architecture.ddd.application.rest.clientapi_query.rest.impl;

import com.architecture.ddd.application.rest.clientapi_query.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_query.rest.UsersApi;
import com.architecture.ddd.application.rest.clientapi_query.service.UserQueryServiceController;
import com.architecture.ddd.application.rest.clientapi_query.service.impl.UserQueryServiceControllerImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController(UserQueryControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserQueryControllerImpl implements UsersApi {

    public final static String BEAN = "userControllerImpl";

    @NonNull
    @Qualifier(UserQueryServiceControllerImpl.BEAN)
    private final UserQueryServiceController userQueryServiceController;

    @Override
    public ResponseEntity<ResponseUser> getAllUsers() {
        return this.userQueryServiceController.getAllUsers();
    }

    @Override
    public ResponseEntity<ResponseUser> getUserByUuid(UUID userUuid) {
        return this.userQueryServiceController.getUserByUuid(userUuid);
    }

}
