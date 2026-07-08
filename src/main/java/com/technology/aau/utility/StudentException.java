package com.technology.aau.utility;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class StudentException extends RuntimeException{


    public StudentException(String messages) {
        super(messages);
    }
    
}
