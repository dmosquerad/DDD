package com.architecture.ddd.domain.data.vo;

import com.architecture.ddd.domain.data.type.DocumentType;
import lombok.Data;

import java.util.UUID;

//Mirar quitar setter mapstruct problem
@Data
//Mirar quitar setter mapstruct problem
//@Value
public class UserVo {

    String id;

    UUID uuid;

    String email;

    String name;

    String role;

    DocumentType documentType;
}
