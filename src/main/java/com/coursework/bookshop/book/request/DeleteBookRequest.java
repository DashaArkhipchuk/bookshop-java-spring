package com.coursework.bookshop.book.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DeleteBookRequest {

    private Integer id;
    private String nothing;

}
