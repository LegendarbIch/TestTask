package com.example.testtask;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CharacterFrequency {
    private Map<Character, Integer> characterFrequencyMap;

    public String toString() {
        return characterFrequencyMap.entrySet().stream().map( e -> "\"" + e.getKey() + "\"" + ":" + e.getValue())
                .collect(Collectors.joining(","));
    }
}
