package com.coursework.bookshop.book.mapper;

import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.request.CreateBookRequest;

public class BookRequestMapper {
    public static Book mapCreateBookRequestToBook(CreateBookRequest createAuthorRequest){
        Book book = Book.builder()
                .title(createAuthorRequest.getTitle())
                .author(AuthorRequestMapper.mapAuthorRequestToAuthor(createAuthorRequest.getAuthor()))
                .genre(createAuthorRequest.getGenre()).publishYear(createAuthorRequest.getPublishYear())
                .price(createAuthorRequest.getPrice())
                .publishYear(createAuthorRequest.getPublishYear())
                .build();

        return book;
    }

    public static CreateBookRequest mapBookToCreateBookRequest(Book book){
        CreateBookRequest request = CreateBookRequest.builder()
                .author(AuthorRequestMapper.mapAuthorToAuthorRequest(book.getAuthor()))
                .title(book.getTitle())
                .genre(book.getGenre())
                .price(book.getPrice())
                .publishYear(book.getPublishYear())
                .build();
        return request;
    }
}
