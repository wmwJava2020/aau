package com.technology.aau.service;
import utility.StudentException;
import com.technology.aau.dto.StudentResponse;
import com.technology.aau.entity.Student;
import com.technology.aau.respository.StudentRepository;
import utility.StudentExceptionMessages;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class StudentServiceImpl implements StudentService {

    Logger log = Logger.getLogger(StudentServiceImpl.class.getName());

    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(ModelMapper modelMapper,
                              StudentRepository studentRepository) {
        this.modelMapper = modelMapper;
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentResponse createStudent(Student req) {
        Student student = modelMapper.map(req, Student.class);
        log.info("Creating student: " + student);
        Student saved = studentRepository.save(student);
        log.info("Student created: " + saved);
        return modelMapper.map(saved, StudentResponse.class);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentException(StudentExceptionMessages.MESSAGES.get(0)));
                // "Student not found"
        studentRepository.delete(student);
        log.info("Student deleted: " + id);
    }

    @Override
    public int grade(int creditHours, int contactHours, int assignmentScore, String status) {

        // Normalize status input
        String normalizedStatus = status.trim().toUpperCase();

        switch (normalizedStatus) {

            case "ACTIVE":
                return (creditHours + contactHours + assignmentScore) / 3;

            case "EXTENSION":
                return (creditHours + contactHours + assignmentScore) / 4;

            case "REGULAR":
                return (creditHours + contactHours + assignmentScore) / 5;

            case "INACTIVE":
                throw new StudentException(StudentExceptionMessages.MESSAGES.get(1));
                // "Student is inactive"

            case "SUSPENDED":
                throw new StudentException(StudentExceptionMessages.MESSAGES.get(2));
                // "Student is suspended"

            default:
                throw new StudentException(StudentExceptionMessages.MESSAGES.get(3));
                // "Invalid student status"
        }
    }



}
