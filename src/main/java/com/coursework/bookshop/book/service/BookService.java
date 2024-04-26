package com.coursework.bookshop.book.service;

import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.CreateBookRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Log4j2
@Service
public class BookService {

    public Book getBook(String title, Double price){
        log.info("Book service Invoked");
        return Book.builder()
                .Id(UUID.randomUUID().toString())
                .title(title)
                .author("someauthor")
                .publishYear(1234)
                .genre("somegenre")
                .price(price)
                .build();
    }

    public Book createBook(CreateBookRequest createBookRequest){
        return Book.builder()
                .Id(UUID.randomUUID().toString())
                .title(createBookRequest.getTitle())
                .author(createBookRequest.getAuthor())
                .publishYear(createBookRequest.getPublishYear())
                .genre(createBookRequest.getGenre())
                .price(createBookRequest.getPrice())
                .build();
    }


}
