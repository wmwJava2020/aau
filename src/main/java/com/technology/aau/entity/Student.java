package com.technology.aau.entity;

import utility.StudentEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tbl_student")
public class Student {

    @Id
    @GeneratedValue
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private StudentEnum status;



}
