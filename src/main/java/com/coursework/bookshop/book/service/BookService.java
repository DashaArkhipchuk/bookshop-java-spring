package com.coursework.bookshop.book.service;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.author.persistence.AuthorRepository;
import com.coursework.bookshop.book.entity.Book;
import com.coursework.bookshop.book.persistence.BookRepository;
import com.coursework.bookshop.book.request.CreateBookRequest;
import com.coursework.bookshop.book.request.DeleteBookRequest;
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
    private final AuthorRepository authorRepository;

    public Book getBook(Integer id){
        log.info("Book service Invoked");
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseGet(() -> Book.builder().build());
    }

    public Book createBook(CreateBookRequest createBookRequest){
        Author build = AuthorRequestMapper.mapAuthorRequestToAuthor(createBookRequest.getAuthor());
        List<Author> byFirstNameAndLastName = authorRepository.findByFirstNameAndLastName(createBookRequest.getAuthor().getFirstName(), createBookRequest.getAuthor().getLastName());
        Author save=null;
        if(byFirstNameAndLastName.isEmpty()){
            save= authorRepository.save(build);
        } else{
            save=byFirstNameAndLastName.getFirst();
        }

        log.info(createBookRequest);

        Book book = Book.builder()
                .title(createBookRequest.getTitle())
                .author(save).publishYear(createBookRequest.getPublishYear())
                .genre(createBookRequest.getGenre())
                .price(createBookRequest.getPrice())
                .build();
        return bookRepository.save(book);


    }
    public void deleteBookByRequest(DeleteBookRequest request){
        bookRepository.deleteById(request.getId());
    }


}
