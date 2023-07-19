package com.koray.studentmanagementsystem.controller;

import com.koray.studentmanagementsystem.entity.Book;
import com.koray.studentmanagementsystem.service.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/books")
@Controller
public class BookController {

    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books",bookService.getAllBooks());
        return "/booktemplates/books";
    }

    @GetMapping("/new")
    public String createBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book",book);
        return "/booktemplates/create_book";
    }

    @PostMapping
    public String createBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "/booktemplates/create_book";
        }
        bookService.addBook(book);
        model.addAttribute("book",null);
        return "redirect:/api/v1/books/new";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model) {
        model.addAttribute("book",bookService.getBookById(id));
        return "/booktemplates/edit_book";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable Long id,@ModelAttribute("book") @Valid Book book,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/booktemplates/edit_book";
        }
        bookService.updateBook(id,book);
        return "redirect:/api/v1/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/api/v1/books";
    }

}
