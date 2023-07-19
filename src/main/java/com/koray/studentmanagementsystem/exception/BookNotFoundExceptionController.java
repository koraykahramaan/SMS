package com.koray.studentmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookNotFoundExceptionController {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<Object> exception(BookNotFoundException bookNotFoundException) {
        return new ResponseEntity<>("The book with the id" + bookNotFoundException.id + " is not found", HttpStatus.NOT_FOUND);
    }
}
