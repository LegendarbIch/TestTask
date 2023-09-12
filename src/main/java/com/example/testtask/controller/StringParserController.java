package com.example.testtask.controller;

import com.example.testtask.payload.response.CharacterFrequency;
import com.example.testtask.payload.request.ParamString;
import com.example.testtask.validation.ResponseErrorValidation;
import com.example.testtask.service.MapSortingService;
import com.example.testtask.service.StringParserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/parse")
public class StringParserController {
    private final StringParserService parserService;
    private final MapSortingService sortingService;
    private final ResponseErrorValidation responseErrorValidation;


    @Autowired
    public StringParserController(StringParserService parser, MapSortingService sortingService, ResponseErrorValidation responseErrorValidation) {
        this.parserService = parser;
        this.sortingService = sortingService;
        this.responseErrorValidation = responseErrorValidation;
    }

    @PostMapping("/onsymbolscount")
    public ResponseEntity<Object> parseString(@Valid @RequestBody ParamString str, BindingResult bindingResult) {

        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;

        Map<Character, Integer> resultMap = parserService.calculateFrequencyOfCharacters(str.getString());
        CharacterFrequency characterFrequency = sortingService.sortCharacterFrequencyMap(resultMap);
        return new ResponseEntity<>(characterFrequency.toString(), HttpStatus.OK);
    }
}
