package com.technology.aau.service;

import com.technology.aau.dto.StudentResponse;
import com.technology.aau.entity.Student;

public interface StudentService {

    StudentResponse createStudent(Student request);
    void deleteStudent(Long id);
    int grade(int creditHours,
              int contactHours,
              int assignmentScore,
              String status);
}
