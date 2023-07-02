package com.graphqltets;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BoolRepository boolRepository;


    @Override
    public List<Book> getAllBooks() {

        return boolRepository.findAll();
    }

    @Override
    public Optional<Book> getBookByTitle(String title) {
       return boolRepository.getBookByTitle(title);
    }

    @Override
    public Book createBook(String author, String title) {
        Book book = new Book();
        System.out.println(book);
        book.setTitle(title);
        book.setAuthor(author);
        return boolRepository.save(book);
    }
}
