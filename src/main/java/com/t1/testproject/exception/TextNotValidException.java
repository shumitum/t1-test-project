package com.t1.testproject.exception;

public class TextNotValidException extends RuntimeException {
    public TextNotValidException(String message) {
        super(message);
    }
}