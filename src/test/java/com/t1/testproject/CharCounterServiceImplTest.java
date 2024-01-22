package com.t1.testproject;


import com.t1.testproject.impl.CharCounterServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CharCounterServiceImplTest {

    @InjectMocks
    private CharCounterServiceImpl charCounterServiceImpl;

    @Test
    void getNumberOfOccurrenceChars_whenInvoked_returnCorrectNumberOfChars() {
        String text = "asssdd";

        Map<Character, Long> charsOccurrence = charCounterServiceImpl.getNumberOfOccurrenceChars(text);

        assertEquals(1L, charsOccurrence.get('a'), "Количество вхождений буквы а должны быть = 1");
        assertEquals(3L, charsOccurrence.get('s'), "Количество вхождений буквы s должны быть = 3");
        assertEquals(2L, charsOccurrence.get('d'), "Количество вхождений буквы d должны быть = 2");
    }

    @Test
    void getNumberOfOccurrenceChars_whenInvoked_returnCorrectOrderOfOccurrenceChars() {
        String text = "asssdd";

        Map<Character, Long> charsOccurrence = charCounterServiceImpl.getNumberOfOccurrenceChars(text);
        List<Map.Entry<Character, Long>> entries = new ArrayList<>(charsOccurrence.entrySet());

        assertEquals(3, entries.size(), "Длина списка должна быть 3");
        assertEquals("s=3", entries.get(0).toString(), "Первой букой в списке должна быть 's' количество вхождений 3");
        assertEquals("d=2", entries.get(1).toString(), "Второй букой в списке должна быть 'd' количество вхождений 2");
        assertEquals("a=1", entries.get(2).toString(), "Третьей букой в списке должна быть 'a' количество вхождений 1");
    }
}