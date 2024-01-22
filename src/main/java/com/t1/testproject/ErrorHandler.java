package com.t1.testproject;

import com.t1.testproject.exception.TextNotValidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleTextNotValidException(final TextNotValidException ex) {
        log.warn("Получен статус 400 BAD REQUEST {}", ex.getMessage());
        return new ErrorResponse(ex.getMessage());
    }

    public record ErrorResponse(String error) {
    }
}
