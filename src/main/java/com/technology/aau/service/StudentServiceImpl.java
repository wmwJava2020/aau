package com.technology.aau.service;

import com.technology.aau.dto.StudentResponse;
import com.technology.aau.entity.Student;
import com.technology.aau.respository.StudentRepository;
import com.technology.aau.utility.StudentEnum;
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
    public void delete(Student student) {
        studentRepository.delete(student);
        log.info("Student deleted: " + student);
    }

    @Override
    public int grade(int creditHours, int contactHours, int assignmentScore) {
        try {
            log.info("Calculating grade for student with credit hours: " + creditHours + ", contact hours: " + contactHours + ", assignment score: " + assignmentScore);
            if (!StudentEnum.ACTIVE.equals(StudentEnum.ACTIVE)) {
            } else {
                return (creditHours * contactHours) + assignmentScore;
            }

        } catch (Exception e) {
        }
        return creditHours;
    }
}