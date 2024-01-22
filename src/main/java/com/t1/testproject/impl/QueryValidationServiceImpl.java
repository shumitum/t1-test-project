package com.t1.testproject.impl;

import com.t1.testproject.QueryValidationService;
import com.t1.testproject.exception.TextNotValidException;
import org.springframework.stereotype.Service;

@Service
public class QueryValidationServiceImpl implements QueryValidationService {
    @Override
    public void validateText(String text) {
        if (text.isEmpty()) {
            throw new TextNotValidException("Строка запроса пустая");
        }
        if (!text.matches(VALIDATION_PATTERN)) {
            throw new TextNotValidException("Строка запроса содержит недопустимый символ");
        }
    }
}
