package com.koray.studentmanagementsystem.service;

import com.koray.studentmanagementsystem.entity.Book;
import com.koray.studentmanagementsystem.exception.BookNotFoundException;
import com.koray.studentmanagementsystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{


    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @Override
    public void updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        existingBook.setBookName(book.getBookName());
        existingBook.setBookType(book.getBookType());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setAmount(book.getAmount());
        existingBook.setId(book.getId());
        bookRepository.save(existingBook);
    }
}
