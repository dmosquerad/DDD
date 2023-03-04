package com.architecture.ddd.domain.data.vo;

import com.architecture.ddd.domain.data.type.DocumentType;
import lombok.Data;

import java.util.UUID;

//Añadir @Builder @Value en vez de @Data
//@Builder
//@Value
@Data
public class UserVo {

    String id;

    UUID uuid;

    String email;

    String name;

    String role;

    DocumentType documentType;
}
