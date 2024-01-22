package com.t1.testproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = Controller.class)
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CharCounterService charCounterService;

    @MockBean
    private QueryValidationService queryValidationService;

    private final Map<Character, Long> charsOccurrence = new HashMap<>();

    @BeforeEach
    void setUp() {
        charsOccurrence.put('a', 1L);
        charsOccurrence.put('s', 1L);
        charsOccurrence.put('d', 1L);
    }

    @Test
    @SneakyThrows
    void getNumberOfOccurrenceChars_whenInvokes_returnMapOfResults() {
        String text = "asd";
        when(charCounterService.getNumberOfOccurrenceChars(text)).thenReturn(charsOccurrence);

        String content = mockMvc.perform(get("/query")
                        .param("text", text))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        verify(queryValidationService, times(1))
                .validateText(text);
        verify(charCounterService, times(1))
                .getNumberOfOccurrenceChars(text);
        assertEquals(objectMapper.writeValueAsString(charsOccurrence), content);
    }
}