package com.architecture.ddd.infrastructure.repository.jpa.dao;

import com.architecture.ddd.domain.data.type.DocumentType;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = UserDao.TABLE_NAME,
        indexes = {
                @Index(name = "email_index", columnList = UserDao.EMAIL, unique = true)
        }
)
public class UserDao implements Serializable {

    public static final String TABLE_NAME = "`user`";
    public static final String ID = "id";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String ROLE = "ROLE";
    public static final String DOCUMENT_TYPE = "document_type";

    private static final long serialVersionUID = 8574906540322181489L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = UserDao.ID, nullable = false, updatable = false)
    private Long id;

    @Column(name = UserDao.EMAIL, nullable = false, unique = true)
    @NotEmpty
    private String email;

    @Column(name = UserDao.NAME, nullable = false)
    @NotEmpty
    private String name;

    @Column(name = UserDao.ROLE, nullable = false)
    @NotEmpty
    private String role;

    @Column(name = UserDao.DOCUMENT_TYPE)
    @Enumerated(EnumType.STRING)
    @NotNull
    private DocumentType documentType;
}
