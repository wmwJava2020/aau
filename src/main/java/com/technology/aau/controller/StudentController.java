package com.technology.aau.controller;

import com.technology.aau.dto.StudentResponse;
import com.technology.aau.entity.Student;
import com.technology.aau.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/score")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<StudentResponse> createStudent(@RequestBody Student student) {
        StudentResponse response = studentService.createStudent(student);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/grade")
    public int grade(@RequestParam int creditHours,
                     @RequestParam int contactHours,
                     @RequestParam int assignmentScore,
                     @RequestParam String status) {
        String normalizedStatus = status.trim().toUpperCase();
        return studentService.grade(creditHours, contactHours, assignmentScore, normalizedStatus);
    }

}
