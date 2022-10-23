package com.architecture.ddd.domain.data.type;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public enum DocumentType {
    DNI, PASSPORT, OTHER
}
