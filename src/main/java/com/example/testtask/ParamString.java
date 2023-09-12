package com.example.testtask;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ParamString {
    @NotEmpty()
    private String string;
}
