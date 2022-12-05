package com.app.emppayroll.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Using lombok for generating parameterized constructor.
@Getter
@AllArgsConstructor
public class ResponseDto {

    private String msg;
    private Object data;

}