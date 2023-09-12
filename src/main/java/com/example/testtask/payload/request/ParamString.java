package com.example.testtask.payload.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ParamString {
    @NotEmpty()
    private String string;
}
