package com.t1.testproject.impl;

import com.t1.testproject.CharCounterService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CharCounterServiceImpl implements CharCounterService {

    @Override
    public Map<Character, Long> getNumberOfOccurrenceChars(String text) {
        Map<Character, Long> charsOccurrence = new HashMap<>();
        Map<Character, Long> occurrenceInReverseOrder = new LinkedHashMap<>();
        for (char symbol : text.toCharArray()) {
            charsOccurrence.computeIfAbsent(symbol, count -> text.chars().filter(ch -> ch == symbol).count());
        }
        charsOccurrence.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> occurrenceInReverseOrder.put(e.getKey(), e.getValue()));
        return occurrenceInReverseOrder;
    }
}
