package com.architecture.ddd.application.rest.clientapi_command.service;

import com.architecture.ddd.application.rest.clientapi_command.dto.ResponseUser;
import com.architecture.ddd.application.rest.clientapi_command.dto.UserBody;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserCommandServiceController {

    ResponseEntity<ResponseUser> createUser(UserBody userBody);

    ResponseEntity<ResponseUser> deleteUserByUuid(UUID uuid);

    ResponseEntity<ResponseUser> putUserByUuid(UUID uuid, UserBody userBody);

    ResponseEntity<ResponseUser> patchUserByUuid(UUID uuid, UserBody userBody);
}
