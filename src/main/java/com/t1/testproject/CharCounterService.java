package com.t1.testproject;

import java.util.Map;

public interface CharCounterService {
    Map<Character, Long> getNumberOfOccurrenceChars(String text);
}
