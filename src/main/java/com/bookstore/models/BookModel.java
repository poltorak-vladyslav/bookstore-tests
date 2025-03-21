package com.bookstore.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookModel {

    private Long id;
    private String title;
    private String description;
    private Long pageCount;
    private String excerpt;
    private String publishDate;
}
