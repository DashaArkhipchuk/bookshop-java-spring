package com.coursework.bookshop.book.controller;

import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class CreateBookController {
    private final BookService bookService;
    @PostMapping("${app.api.path.book.createBook}")
    public ResponseEntity<Book> createBook(
            @RequestBody CreateBookRequest createBookRequest
    ){
        Book book = bookService.createBook(createBookRequest);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
