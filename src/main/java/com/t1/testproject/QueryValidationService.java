package com.t1.testproject;

public interface QueryValidationService {
    String VALIDATION_PATTERN = "[a-z]+";

    void validateText(String text);
}
