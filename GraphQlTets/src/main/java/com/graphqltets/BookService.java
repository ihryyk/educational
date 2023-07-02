package com.graphqltets;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBookByTitle(String title);

    Book createBook(String author, String title);

}