package com.architecture.ddd.infrastructure.data.message.dto;

import com.architecture.ddd.domain.data.type.DocumentType;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Value
@Builder
@Jacksonized
public class UserMessageDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 2118732460091013028L;

    String id;

    @NotNull
    UUID uuid;

    String email;

    String name;

    String role;

    DocumentType documentType;
}