package com.coursework.bookshop.author.persistence;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
