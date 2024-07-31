package com.jwt.itau.model;

import java.util.Arrays;
import java.util.List;

public class Role {
    private String value;
    private static final List<String> VALID_ROLES = Arrays.asList("Admin", "Member", "External");

    public Role(String value) {
        if (!VALID_ROLES.contains(value)) {
            throw new IllegalArgumentException("Invalid role: " + value);
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

