package com.example.controller;
import com.example.model.Author;
import com.example.model.Book;
import com.example.service.AuthorService;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public Book bookById(@Argument int id) {
        return bookService.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorService.getById(book.authorId());
    }

    @MutationMapping
    public Book addBook(@Argument Book book) {
        return bookService.addBook(book);
    }
}
