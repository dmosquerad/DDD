package com.architecture.ddd.application.rest.clientapi.service;

import com.architecture.ddd.application.rest.clientapi.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi.dto.UserBody;
import org.springframework.http.ResponseEntity;

public interface UserServiceController {

    ResponseEntity<ResponseUser> getAllUsers();

    ResponseEntity<ResponseUser> getUserById(String id);

    ResponseEntity<ResponseUser> createUser(UserBody userBody);

    ResponseEntity<ResponseUser> deleteUserById(String id);

    ResponseEntity<ResponseUser> putUserById(String id, UserBody userBody);

    ResponseEntity<ResponseUser> patchUserByUUID(String id, UserBody userBody);
}
