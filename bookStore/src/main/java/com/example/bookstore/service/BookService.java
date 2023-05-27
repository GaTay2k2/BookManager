package com.example.bookstore.service;

import com.example.bookstore.etity.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book>getAllBook() {
        return bookRepository.findAll();
    }

    public Book getBookId(int id) {
        return bookRepository.findById(id).get();
    }
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }
}
