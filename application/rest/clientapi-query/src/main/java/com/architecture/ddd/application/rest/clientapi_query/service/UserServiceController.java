package com.architecture.ddd.application.rest.clientapi_query.service;

import com.architecture.ddd.application.rest.clientapi_query.dto.ResponseUser;
import org.springframework.http.ResponseEntity;

public interface UserServiceController {

    ResponseEntity<ResponseUser> getAllUsers();

    ResponseEntity<ResponseUser> getUserById(String id);

}
