package com.architecture.ddd.domain.data.vo;

import com.architecture.ddd.domain.data.type.DocumentType;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder(toBuilder = true)
public class UserVo {

    String id;

    UUID uuid;

    String email;

    String name;

    String role;

    DocumentType documentType;
}
