package com.efiom.ecommerce.enums;

import lombok.Getter;

@Getter

public enum ResponseCodeEnum {

    SUCCESS(0, "Success"),
    ERROR(-1, "An error occurred. Error message: ${errorMessage}"),

    private final int code;
    private final String description;

    ResponseCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    ResponseCodeEnum(0, "Success") {
        this.code = 0;
        this.description = "Success";
    }






}
