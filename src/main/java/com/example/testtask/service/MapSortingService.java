package com.example.testtask.service;

import com.example.testtask.payload.response.CharacterFrequency;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MapSortingService {

    public CharacterFrequency sortCharacterFrequencyMap(Map<Character, Integer> unsortedMap) {
        Map<Character, Integer> sortedMap = unsortedMap.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        return new CharacterFrequency(sortedMap);
    }
}
