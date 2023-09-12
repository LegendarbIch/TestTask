package com.example.testtask;

import com.example.testtask.service.MapSortingService;
import com.example.testtask.service.StringParserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.assertj.core.api.Assertions.assertThat;


public class ParsingTest {

    StringParserService stringParserService = new StringParserService();
    MapSortingService mapSortingService = new MapSortingService();

    public static final Logger LOG = LoggerFactory.getLogger(ParsingTest.class);
    @Test
    public void split_the_string_into_the_occurrence_of_each_character_test1() {
        assertThat(stringParserService.calculateFrequencyOfCharacters("aaaaabcccc")).containsEntry('a', 5).containsEntry('b', 1).containsEntry('c', 4);
        LOG.info(stringParserService.calculateFrequencyOfCharacters("aaaaabcccc").toString());
    }
    @Test
    public void split_the_string_into_the_occurrence_of_each_character_test2() {
        assertThat(stringParserService.calculateFrequencyOfCharacters("111jjjooo9090")).containsEntry('1', 3).
                containsEntry('j', 3).containsEntry('o', 3).containsEntry('9', 2).containsEntry('0', 2);
        LOG.info(stringParserService.calculateFrequencyOfCharacters("111jjjooo9090").toString());
    }

    @Test
    public void sort_the_frequency_of_values_for_test1() {
        assertThat(stringParserService.calculateFrequencyOfCharacters("aaaaabcccc")).containsEntry('a', 5).containsEntry('b', 1).containsEntry('c', 4);
        LOG.info(mapSortingService.sortCharacterFrequencyMap(stringParserService.calculateFrequencyOfCharacters("aaaaabcccc")).getCharacterFrequencyMap().toString());
    }

    @Test
    public void sort_the_frequency_of_values_for_test2() {
        assertThat(stringParserService.calculateFrequencyOfCharacters("111jjjooo9090")).containsEntry('1', 3).
                containsEntry('j', 3).containsEntry('o', 3).containsEntry('9', 2).containsEntry('0', 2);
        LOG.info(mapSortingService.sortCharacterFrequencyMap(stringParserService.calculateFrequencyOfCharacters("111jjjooo9090")).getCharacterFrequencyMap().toString());
    }
}
