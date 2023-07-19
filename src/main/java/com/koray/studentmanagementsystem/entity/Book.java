package com.koray.studentmanagementsystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    @NotEmpty(message = "Book name can not be empty")
    @Size(min = 4,max = 250)
    private String bookName;

    @Column(name = "book_type")
    @NotEmpty(message = "Book type can not be empty")
    @Size(min = 2,max = 50)
    private String bookType;

    @Column(name = "author")
    @NotEmpty(message = "Author name can not be empty")
    @Size(min = 5,max = 200)
    private String author;

    @Column(name = "amount")
    @Min(value = 1,message = "Amount can not be negative or zero")
    @Max(value = 9999,message = "Amount can not be higher than 9999")
    private int amount;

    public Book(Long id, String bookName, String bookType, String author, int amount) {
        this.id = id;
        this.bookName = bookName;
        this.bookType = bookType;
        this.author = author;
        this.amount = amount;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
