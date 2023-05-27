package com.example.bookstore.service;

import com.example.bookstore.etity.MyBookList;
import com.example.bookstore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {
    @Autowired
    private MyBookRepository myBookRepository;
    public void saveMyBooks(MyBookList book) {
        myBookRepository.save(book);
    }
    public List<MyBookList>getAllMyBook() {
        return myBookRepository.findAll();
    }

    public void deleteById(int id) {
        myBookRepository.deleteById(id);
    }
}
