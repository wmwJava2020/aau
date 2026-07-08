package com.technology.aau.utility;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

public class StudentException extends RuntimeException {

    String message;
    public StudentException(String messages) {
        super(messages);
    }

}
