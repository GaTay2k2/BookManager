package com.example.bookstore.controller;

import com.example.bookstore.etity.Book;
import com.example.bookstore.etity.MyBookList;
import com.example.bookstore.service.BookService;
import com.example.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {

        List<Book>list=bookService.getAllBook();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("bookList");
//        modelAndView.addObject("book", list);
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList>list=myBookListService.getAllMyBook();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book book = bookService.getBookId(id);
        MyBookList myBook = new MyBookList(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
        myBookListService.saveMyBooks(myBook);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.getBookId(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }
    @RequestMapping("deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
