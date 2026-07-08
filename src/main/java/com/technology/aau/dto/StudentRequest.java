package com.technology.aau.dto;

import com.technology.aau.utility.StudentEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
@Data
@Getter
@Setter
@Component
public class StudentRequest {
    // Getters and setters
    @Getter
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private StudentEnum status;

}
