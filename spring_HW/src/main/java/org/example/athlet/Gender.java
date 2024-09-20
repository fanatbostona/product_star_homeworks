package org.example.athlet;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public static Gender of(String code) throws IOException {
        return Stream.of(values())
                .filter(d -> Objects.equals(d.code, code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("wrong gender: " + code));
    }
}
