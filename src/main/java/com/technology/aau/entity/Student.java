package com.technology.aau.entity;

import com.technology.aau.utility.StudentEnum;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name="tbl_student")
public class Student {

    @Id
    @GeneratedValue
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private StudentEnum status;



}
