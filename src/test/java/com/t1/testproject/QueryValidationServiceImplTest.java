package com.t1.testproject;

import com.t1.testproject.exception.TextNotValidException;
import com.t1.testproject.impl.QueryValidationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class QueryValidationServiceImplTest {

    @InjectMocks
    private QueryValidationServiceImpl queryValidationService;

    @Test
    void validateString_whenInvokedWithCorrectText_doesNotThrowAnyException() {
        String text = "asd";

        assertDoesNotThrow(() -> queryValidationService.validateText(text));
    }

    @Test
    void validateString_whenInvoked_throwException() {
        String text = "as  d";

        assertThrows(TextNotValidException.class, () -> queryValidationService.validateText(text));
    }

    @Test
    void validateString_whenInvokedWithDigit_throwException() {
        String text = "1asd";

        assertThrows(TextNotValidException.class, () -> queryValidationService.validateText(text));
    }

    @Test
    void validateString_whenInvokedWithEmptyText_throwException() {
        String text = "";

        assertThrows(TextNotValidException.class, () -> queryValidationService.validateText(text));
    }

    @Test
    void validateString_whenInvokedWithSymbols_throwException() {
        String text = ")_asd";

        assertThrows(TextNotValidException.class, () -> queryValidationService.validateText(text));
    }

    @Test
    void validateString_whenInvokedWithUpperCaseText_throwException() {
        String text = "ASd";

        assertThrows(TextNotValidException.class, () -> queryValidationService.validateText(text));
    }

    @Test
    void validateString_whenInvokedWithCyrillicText_throwException() {
        String text = "фыв";

        assertThrows(TextNotValidException.class, () -> queryValidationService.validateText(text));
    }

    @Test
    void validateString_whenInvokedWithUpperCaseCyrillicText_throwException() {
        String text = "фыВ";

        assertThrows(TextNotValidException.class, () -> queryValidationService.validateText(text));
    }
}