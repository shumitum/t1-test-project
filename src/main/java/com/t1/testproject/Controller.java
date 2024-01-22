package com.t1.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final CharCounterService service;
    private final QueryValidationService queryValidationService;

    @GetMapping("/query")
    public Map<Character, Long> getNumberOfOccurrenceChars(@RequestParam String text) {
        String correctedText = text.trim();
        queryValidationService.validateText(correctedText);
        return service.getNumberOfOccurrenceChars(correctedText);
    }
}
