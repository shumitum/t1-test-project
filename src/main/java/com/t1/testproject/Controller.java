package com.t1.testproject;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name = "API", description = "для вычисления частоты встречи символов в заданной строке")
public class Controller {
    private final CharCounterService service;
    private final QueryValidationService queryValidationService;

    @Operation(summary = "Эндпоинт для вычисления частоты встречи символов в строке", description = "Эндпоинт принимает на вход строку, " +
            "состоящую из символов английского языка в нижнем регистре, и возвращает количество вхождений каждого символа" +
            " строки в виде мапы, пример  “a”: 5, “c”: 4, “b”: 1. Допускаются пробелы в начале и в конце строки, но не" +
            " допускаются в середине строки. Если строка содержит хотя бы один символ кроме символов английского языка" +
            " в нижнем регистре вернется статус 400 BAD REQUEST.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Результат вычисления частоты встречи символов в строке",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Строка запроса пустая /" +
                    " Строка запроса содержит недопустимый символ", content = @Content)
    })
    @GetMapping("/query")
    public Map<Character, Long> getNumberOfOccurrenceChars(@RequestParam String text) {
        String correctedText = text.trim();
        queryValidationService.validateText(correctedText);
        return service.getNumberOfOccurrenceChars(correctedText);
    }
}
