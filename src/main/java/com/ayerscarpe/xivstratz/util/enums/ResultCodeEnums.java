package com.ayerscarpe.xivstratz.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ResultCodeEnums {
    SUCCESS(20000),
    ERROR(20001);
    private final int code;
}
