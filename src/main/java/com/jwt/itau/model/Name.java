package com.jwt.itau.model;

public class Name {
    private String value;

    public Name(String value) {
        if (value == null || value.length() > 256 || !value.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("Invalid name: " + value);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
