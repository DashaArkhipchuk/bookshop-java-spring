package com.coursework.bookshop.author.controller;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.author.request.CreateAuthorRequest;
import com.coursework.bookshop.author.service.AuthorService;
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
public class CreateAuthorController {
    private final AuthorService authorService;
    @PostMapping("${app.api.path.author.createAuthor}")
    public ResponseEntity<Author> createAuthor(
            @RequestBody CreateAuthorRequest createAuthorRequest
    ){

        Author author = authorService.addAuthor(createAuthorRequest);
        return new ResponseEntity<>(author,HttpStatus.OK);
    }
}
