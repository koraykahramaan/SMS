package com.koray.studentmanagementsystem.exception;

public class UsernameNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    String message;

    public UsernameNotFoundException(String message) {
        this.message = message;
    }
}
