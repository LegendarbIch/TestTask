package com.example.testtask;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/parse")
public class StringParserController {
    private final StringParserService parserService;
    private final MapSortingService sortingService;


    @Autowired
    public StringParserController(StringParserService parser, MapSortingService sortingService) {
        this.parserService = parser;
        this.sortingService = sortingService;
    }

    @PostMapping("/onsymbolscount")
    public ResponseEntity<String> parseString(@Valid @RequestBody ParamString str) {

        Map<Character, Integer> resultMap = parserService.calculateFrequencyOfCharacters(str.getString());
        CharacterFrequency characterFrequency = sortingService.sortCharacterFrequencyMap(resultMap);
        return new ResponseEntity<>(characterFrequency.toString(), HttpStatus.OK);
    }
}
