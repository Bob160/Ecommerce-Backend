package com.efiom.ecommerce.enums;

import lombok.Getter;

@Getter

public enum ResponseCodeEnum {

    SUCCESS(200, "Success"),
    ERROR(400, "An error occurred. Error message : ${errorMessage}"),
    PRODUCT_NOT_FOUND(401, "No products found"),
    CATEGORY_NOT_FOUND(402, "No category found"),
    CATEGORY_ALREADY_EXIST(403, "Category already exist"),
    ORDERS_NOT_FOUND(402, "No Order found"),
    ERROR_UPDATING_ORDER_STATUS(403, "Could not update order status"),

    ;

    ResponseCodeEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private final int code;
    private final String description;







}
