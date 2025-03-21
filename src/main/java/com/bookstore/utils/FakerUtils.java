package com.bookstore.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FakerUtils {

    private static Faker FAKER;

    public static Faker getFaker() {
        if (FAKER == null) {
            FAKER = new Faker();
        }
        return FAKER;
    }
}
