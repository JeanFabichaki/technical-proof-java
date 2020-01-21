package com.tools.model;

public enum InformationType {

    SELLER("001"),
    CUSTOMER("002"),
    SALES("003");

    public String code;

    InformationType(final String code) {
        this.code = code;
    }
}
