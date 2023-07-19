package com.koray.studentmanagementsystem.exception;

public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    Long id;

    public BookNotFoundException(Long id) {
        this.id=id;
    }
}
