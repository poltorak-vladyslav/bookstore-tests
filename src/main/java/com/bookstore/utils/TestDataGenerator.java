package com.bookstore.utils;

import com.bookstore.models.AuthorModel;
import com.bookstore.models.BookModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static com.bookstore.utils.DateUtils.convertDateToString;
import static com.bookstore.utils.FakerUtils.getFaker;
import static java.time.ZoneOffset.ofHours;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestDataGenerator {

    public static AuthorModel getAuthorModel() {
        return AuthorModel.builder()
                .id(getFaker().number().randomNumber(3, true))
                .firstName(getFaker().name().firstName())
                .lastName(getFaker().name().lastName())
                .idBook(getFaker().number().randomNumber(3, true))
                .build();
    }

    public static BookModel getBookModel() {
        return BookModel.builder()
                .id(getFaker().number().randomNumber(3, true))
                .title(getFaker().book().title())
                .description(getFaker().book().genre())
                .pageCount(getFaker().number().randomNumber(3, true))
                .excerpt(getFaker().lorem().paragraph())
                .publishDate(convertDateToString(ZonedDateTime.now(ZoneId.of("UTC"))))
                .build();
    }
}
