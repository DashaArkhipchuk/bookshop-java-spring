package com.coursework.bookshop.book.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateBookRequest {
    private Integer id;
    private String title;
    private int publishYear;
    private String genre;
    private Double price;
}
