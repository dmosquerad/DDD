package com.architecture.ddd.application.rest.clientapi_query.service;

import com.architecture.ddd.application.rest.clientapi_query.dto.ResponseUser;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserQueryServiceController {

    ResponseEntity<ResponseUser> getAllUsers();

    ResponseEntity<ResponseUser> getUserByUuid(UUID uuid);

}
