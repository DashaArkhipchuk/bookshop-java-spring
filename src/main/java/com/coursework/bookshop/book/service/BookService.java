package com.coursework.bookshop.book.service;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.author.persistence.AuthorRepository;
import com.coursework.bookshop.author.service.AuthorService;
import com.coursework.bookshop.book.dto.BookDto;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.mapper.BookDtoMapper;
import com.coursework.bookshop.book.mapper.BookRequestMapper;
import com.coursework.bookshop.book.persistence.BookRepository;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.book.request.DeleteBookRequest;
import com.coursework.bookshop.book.request.UpdateBookRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final BookDtoMapper bookDtoMapper;


    public Book getBook(Integer id){
        log.info("Book service Invoked");
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseGet(() -> Book.builder().build());
    }

    public List<BookDto> getAllBooks(){
        List<Book> b= bookRepository.findAll();
        return bookDtoMapper.mapBooksToBookDtos(b);
    }

    public Book createBook(CreateBookRequest createBookRequest){
        Author build = AuthorRequestMapper.mapAuthorRequestToAuthor(createBookRequest.getAuthor());
//        List<Author> byFirstNameAndLastName = authorRepository.findByFirstNameAndLastName(createBookRequest.getAuthor().getFirstName(), createBookRequest.getAuthor().getLastName());
        Author existing = authorService.findExisting(build);


        log.info(createBookRequest);

        Book book= BookRequestMapper.mapCreateBookRequestToBook(createBookRequest);

//        Book book = Book.builder()
//                .title(createBookRequest.getTitle())
//                .author(existing).publishYear(createBookRequest.getPublishYear())
//                .genre(createBookRequest.getGenre())
//                .price(createBookRequest.getPrice())
//                .build();
        return bookRepository.save(book);


    }
    public void deleteBookByRequest(DeleteBookRequest request){
        bookRepository.deleteById(request.getId());
    }


    public Book updateBook(UpdateBookRequest updateBookRequest) {
        Book book = getBook(updateBookRequest.getId());
        book.setTitle(updateBookRequest.getTitle());
        book.setGenre(updateBookRequest.getGenre());
        book.setPublishYear(updateBookRequest.getPublishYear());
        book.setPrice(updateBookRequest.getPrice());
        return bookRepository.save(book);

    }
}
