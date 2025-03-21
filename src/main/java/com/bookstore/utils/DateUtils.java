package com.bookstore.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

import static java.time.format.DateTimeFormatter.ofPattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateUtils {

    private final static String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'";

    public static String convertDateToString(ZonedDateTime zonedDateTime) {
        return zonedDateTime.format(ofPattern(DATE_PATTERN));
    }
}
