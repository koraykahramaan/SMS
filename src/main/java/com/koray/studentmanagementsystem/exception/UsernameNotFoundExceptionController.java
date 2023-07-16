package com.koray.studentmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsernameNotFoundExceptionController {

        @ExceptionHandler(UsernameNotFoundException.class)
        public ResponseEntity<Object> exception(UsernameNotFoundException exception) {
                return new ResponseEntity<>(exception.message, HttpStatus.NOT_FOUND);
        }
}
