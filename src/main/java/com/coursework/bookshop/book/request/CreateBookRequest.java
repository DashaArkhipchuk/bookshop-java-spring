package com.coursework.bookshop.book.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookRequest {
    private String title;
    private String author;
    private int publishYear;
    private String genre;
    private Double price;

}
