package com.technology.aau.utility;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private UUID studentId;
    private int contactHours;
    private int creditHours;
    private int creditScore;
}
