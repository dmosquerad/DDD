package com.architecture.ddd.application.rest.clientapi_command.service;

import com.architecture.ddd.application.rest.clientapi_command.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import org.springframework.http.ResponseEntity;

public interface UserServiceController {

    ResponseEntity<ResponseUser> createUser(UserBody userBody);

    ResponseEntity<ResponseUser> deleteUserById(String id);

    ResponseEntity<ResponseUser> putUserById(String id, UserBody userBody);

    ResponseEntity<ResponseUser> patchUserByUUID(String id, UserBody userBody);
}
