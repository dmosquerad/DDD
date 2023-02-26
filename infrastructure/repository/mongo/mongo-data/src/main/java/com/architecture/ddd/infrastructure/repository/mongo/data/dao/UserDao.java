package com.architecture.ddd.infrastructure.repository.mongo.data.dao;

import com.architecture.ddd.domain.data.type.DocumentType;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Document(UserDao.COLLECTION_NAME)
public class UserDao {

    public static final String COLLECTION_NAME = "user";
    public static final String ID = "_id";
    public static final String UUID = "uuid";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String ROLE = "role";
    public static final String DOCUMENT_TYPE = "document_type";

    @Field(name = UserDao.ID)
    @MongoId
    private String id;

    @Field(name = UserDao.UUID)
    @Indexed(unique = true)
    @NotEmpty
    private String uuid;

    @Field(name = UserDao.EMAIL)
    @Indexed(unique = true)
    @NotEmpty
    private String email;

    @Field(name = UserDao.NAME)
    @NotEmpty
    private String name;

    @Field(name = UserDao.ROLE)
    @NotEmpty
    private String role;

    @Field(name = UserDao.DOCUMENT_TYPE)
    @NotNull
    private DocumentType documentType;
}
