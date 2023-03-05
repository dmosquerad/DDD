package com.architecture.ddd.domain.util;

import org.mapstruct.Named;

import java.util.UUID;

public class ValueObjectUtil {

    public static final String GENERATE_UUID = "generateUuid";

    @Named(ValueObjectUtil.GENERATE_UUID)
    public static UUID generateUuid() {
        return UUID.randomUUID();
    }
}
