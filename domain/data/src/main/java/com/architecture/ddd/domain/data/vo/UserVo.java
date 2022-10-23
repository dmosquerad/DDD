package com.architecture.ddd.domain.data.vo;

import com.architecture.ddd.domain.data.type.DocumentType;
import lombok.Value;

@Value
public class UserVo {

    String id;

    String email;

    String name;

    String role;

    DocumentType documentType;
}
