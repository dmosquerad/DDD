package com.architecture.ddd.application.rest.clientapi.boundary.mapper.vo;

import com.architecture.ddd.application.rest.clientapi.dto.UserBody;
import com.architecture.ddd.domain.data.type.DocumentType;
import com.architecture.ddd.domain.data.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.Objects;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserVoMapper {

    UserVoMapper INSTANCE = Mappers.getMapper(UserVoMapper.class);

    @Mapping(target = "id", ignore = true)
    UserVo toUserVo(UserBody userBody);

    UserVo toUserVo(String id, UserBody userBody);
    
    default UserVo toUserVoUpdate(UserBody userBody, UserVo userVo) {
        if (userBody == null) {
            return userVo;
        }

        String id = userVo.getId();
        String email = userVo.getEmail();
        String name = userVo.getName();
        String role = userVo.getRole();
        DocumentType documentType = userVo.getDocumentType();
        if (userBody != null) {
            if (Objects.nonNull(userBody.getEmail())) {
                email = userBody.getEmail();
            }
            if (Objects.nonNull(userBody.getName())) {
                name = userBody.getName();
            }
            if (Objects.nonNull(userBody.getRole())) {
                role = userBody.getRole();
            }
            if (Objects.nonNull(userBody.getDocumentType())) {
                documentType = this.documentTypeEnumToDocumentType(userBody.getDocumentType());
            }
        }

        return new UserVo(id, email, name, role, documentType);
    }

    default DocumentType documentTypeEnumToDocumentType(UserBody.DocumentTypeEnum documentTypeEnum) {
        if (documentTypeEnum == null) {
            return null;
        }

        DocumentType documentType;

        switch (documentTypeEnum) {
            case DNI:
                documentType = DocumentType.DNI;
                break;
            case PASSPORT:
                documentType = DocumentType.PASSPORT;
                break;
            case OTHER:
                documentType = DocumentType.OTHER;
                break;
            default:
                throw new IllegalArgumentException("Unexpected enum constant: " + documentTypeEnum);
        }

        return documentType;
    }
}
