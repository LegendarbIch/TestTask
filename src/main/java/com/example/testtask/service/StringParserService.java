package com.example.testtask.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StringParserService {

    public Map<Character, Integer> calculateFrequencyOfCharacters(String str) {
        char[] arr = str.toCharArray();
        Map<Character, Integer> symbolAndFrequency = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int frequency = 1;
            if (i >= 1) {
                if (arr[i-1] == arr[i]) {
                    continue;
                }
            }
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    frequency++;
                }
            }
            if (!symbolAndFrequency.containsKey(arr[i])) {
                symbolAndFrequency.put(arr[i], frequency);
            }

        }
        return symbolAndFrequency;
    }
}
