package org.example.athlet;

import java.io.IOException;
import java.util.Objects;
import java.util.stream.Stream;

public enum Distance {
    FIVE_KM("5 km"),
    TEN_KM("10 km");

    private final String code;

    Distance(String code) {
        this.code = code;
    }

    public static Distance of(String code) throws IOException {
        return Stream.of(values())
                .filter(d -> Objects.equals(d.code, code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("wrong distance: " + code));
    }
}