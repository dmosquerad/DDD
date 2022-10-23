package com.architecture.ddd.application.rest.clientapi.rest.impl;

import com.architecture.ddd.application.rest.clientapi.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi.dto.UserBody;
import com.architecture.ddd.application.rest.clientapi.rest.UsersApi;
import com.architecture.ddd.application.rest.clientapi.service.UserServiceController;
import com.architecture.ddd.application.rest.clientapi.service.impl.UserServiceControllerImpl;
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

    @Override
    public ResponseEntity<ResponseUser> createUser(UserBody userBody) {
        return this.userServiceController.createUser(userBody);
    }

    @Override
    public ResponseEntity<ResponseUser> deleteUserById(String id) {
        return this.userServiceController.deleteUserById(id);
    }

    @Override
    public ResponseEntity<ResponseUser> putUserById(String id, UserBody userBody) {
        return this.userServiceController.putUserById(id, userBody);
    }

    @Override
    public ResponseEntity<ResponseUser> patchUserById(String id, UserBody userBody) {
        return this.userServiceController.patchUserByUUID(id, userBody);
    }
}
