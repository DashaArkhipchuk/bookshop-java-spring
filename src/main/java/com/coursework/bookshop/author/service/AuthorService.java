package com.coursework.bookshop.author.service;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.mapper.AuthorRequestMapper;
import com.coursework.bookshop.author.persistence.AuthorRepository;
import com.coursework.bookshop.author.request.CreateAuthorRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author addAuthor(CreateAuthorRequest createAuthorRequest){
        Author author = AuthorRequestMapper.mapAuthorRequestToAuthor(createAuthorRequest);

        return authorRepository.save(author);
    }

    public Author getAuthor(Integer id){
        Optional<Author> byId = authorRepository.findById(id);
        return byId.orElseGet(()->Author.builder().build());

    }


}
