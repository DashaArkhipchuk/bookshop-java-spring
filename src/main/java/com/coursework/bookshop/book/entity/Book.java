package com.coursework.bookshop.book.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private String Id;
    private String title;
    private String author;
    private int publishYear;
    private String genre;
    private Double price;
}
