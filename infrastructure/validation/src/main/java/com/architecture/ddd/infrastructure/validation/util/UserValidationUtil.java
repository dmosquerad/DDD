package com.architecture.ddd.infrastructure.validation.util;

import com.architecture.ddd.domain.data.type.DocumentType;
import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserValidationUtil {

    public static UserVo validateUserVoToUpdate(final @NonNull UserVo userVoExpected, final @NonNull UserVo userVoCurrent) {
        String id = userVoExpected.getId();
        UUID uuid = userVoExpected.getUuid();
        String email = userVoExpected.getEmail();
        String role = userVoExpected.getRole();
        String name = userVoExpected.getName();
        DocumentType documentType = userVoExpected.getDocumentType();

        if (Objects.nonNull(userVoCurrent.getId())) {
            id = userVoCurrent.getId();
        }
        if (Objects.nonNull(userVoCurrent.getUuid())) {
            uuid = userVoCurrent.getUuid();
        }
        if (Objects.nonNull(userVoCurrent.getEmail())) {
            email = userVoCurrent.getEmail();
        }
        if (Objects.nonNull(userVoCurrent.getRole())) {
            role = userVoCurrent.getRole();
        }
        if (Objects.nonNull(userVoCurrent.getName())) {
            name = userVoCurrent.getName();
        }
        if (Objects.nonNull(userVoCurrent.getDocumentType())) {
            documentType = userVoCurrent.getDocumentType();
        }

        return UserVo.builder()
                .id(id)
                .uuid(uuid)
                .email(email)
                .role(role)
                .name(name)
                .documentType(documentType)
                .build();
    }
}
