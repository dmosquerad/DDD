package com.architecture.ddd.infrastructure.validation.util;

import com.architecture.ddd.domain.data.vo.UserVo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserValidationUtil {

    public static UserVo validateUserVoToUpdate(final @NonNull UserVo userVoExpected, final @NonNull UserVo userVoCurrent) {
        UserVo.UserVoBuilder userVoFinal = userVoExpected.toBuilder();

        if (Objects.nonNull(userVoCurrent.getId())) {
            userVoFinal.id(userVoCurrent.getId());
        }
        if (Objects.nonNull(userVoCurrent.getUuid())) {
            userVoFinal.uuid(userVoCurrent.getUuid());
        }
        if (Objects.nonNull(userVoCurrent.getEmail())) {
            userVoFinal.email(userVoCurrent.getEmail());
        }
        if (Objects.nonNull(userVoCurrent.getRole())) {
            userVoFinal.role(userVoCurrent.getRole());
        }
        if (Objects.nonNull(userVoCurrent.getName())) {
            userVoFinal.name(userVoCurrent.getName());
        }
        if (Objects.nonNull(userVoCurrent.getDocumentType())) {
            userVoFinal.documentType(userVoCurrent.getDocumentType());
        }

        return userVoFinal.build();
    }
}
