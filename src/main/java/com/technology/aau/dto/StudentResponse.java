package com.technology.aau.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Getter
@Setter
@Component
public class StudentResponse {

    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
