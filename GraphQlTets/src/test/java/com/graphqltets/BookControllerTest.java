package com.graphqltets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import static org.mockito.Mockito.when;

@GraphQlTest(BookController.class)
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private BookService bookService;

    @Test
    void createBookTest() {
        Book book = new Book();
        book.setId(1L);
        book.setAuthor("author");
        book.setTitle("title");
        when(bookService.createBook("author", "title")).thenReturn(book);
        this.graphQlTester.documentName("createBook")
                .variable("author", "author")
                .variable("title", "title")
                .execute()
                .path("createBook").matchesJson("{\"id\":\"1\",\"title\":\"title\",\"author\":\"author\"}");
    }
}
