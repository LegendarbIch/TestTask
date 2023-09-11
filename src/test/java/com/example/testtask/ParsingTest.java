package com.example.testtask;

import org.junit.jupiter.api.Test;


public class ParsingTest {
    StringParserService stringParserService = new StringParserService();
    MapSortingService mapSortingService = new MapSortingService();
    @Test
    public void split_the_string_into_the_occurrence_of_each_character() {
        System.out.println(stringParserService.calculateFrequencyOfCharacters("aaaaabcccc"));
    }

    @Test
    public void sort_the_frequency_of_values() {
        System.out.println(mapSortingService.sortCharacterFrequencyMap(stringParserService.calculateFrequencyOfCharacters("aaaaabcccc")));
    }
}
