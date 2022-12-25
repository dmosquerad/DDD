package com.architecture.ddd.application.rest.clientapi_query.rest.impl;

import com.architecture.ddd.application.rest.clientapi_query.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_query.rest.UsersApi;
import com.architecture.ddd.application.rest.clientapi_query.service.UserServiceController;
import com.architecture.ddd.application.rest.clientapi_query.service.impl.UserServiceControllerImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController(UserControllerImpl.BEAN)
@RequiredArgsConstructor
public class UserControllerImpl implements UsersApi {

    public final static String BEAN = "userControllerImpl";

    @NonNull
    @Qualifier(UserServiceControllerImpl.BEAN)
    private final UserServiceController userServiceController;

    @Override
    public ResponseEntity<ResponseUser> getAllUsers() {
        return this.userServiceController.getAllUsers();
    }

    @Override
    public ResponseEntity<ResponseUser> getUserById(String id) {
        return this.userServiceController.getUserById(id);
    }

}
