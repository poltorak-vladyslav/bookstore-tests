package com.bookstore.configuration;

import java.util.Arrays;
import java.util.Optional;

public enum Environment {

    DEV, QA;

    public static Environment getEnvironment() {
        String env = Optional.ofNullable(System.getenv("env")).orElse(DEV.name());
        return Arrays.stream(values())
                .filter(environment -> environment.name().equalsIgnoreCase(env))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Environment '%s' not found".formatted(env)));
    }
}
