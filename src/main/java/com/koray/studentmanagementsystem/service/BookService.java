package com.koray.studentmanagementsystem.service;

import com.koray.studentmanagementsystem.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    void addBook(Book book);

    void deleteBookById(Long id);

    Book getBookById(Long id);

    void updateBook(Long id, Book book);
}
