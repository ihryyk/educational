package com.graphqltets;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @QueryMapping
    public List<Book> getAllBooks(){
     return bookService.getAllBooks();
    }

    @QueryMapping
    public Book getBookByTitle (@Argument String title){
        return bookService.getBookByTitle(title).orElseThrow(()-> new BookException("Book not found"));
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String author){
        return bookService.createBook(author,title);
    }
}
