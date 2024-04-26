package com.coursework.bookshop.book.controller;

import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequestMapping("${app.api.path.version.v1}")
@RequiredArgsConstructor
public class GetBookController {
    private final BookService bookService;
    @GetMapping("${app.api.path.book.getBook}")
    public ResponseEntity<Book> getBuilding(
            @PathVariable String title,
//            String author,
//            String publishyear,
//            String genre,
            @RequestParam Double price
    ){
        Book book = bookService.getBook(title, price);
        log.info("Builder: "+book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
