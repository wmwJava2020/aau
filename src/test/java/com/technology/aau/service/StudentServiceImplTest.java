package com.technology.aau.service;

import com.technology.aau.entity.Student;
import com.technology.aau.respository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock
    private StudentRepository repository;

    private StudentServiceImpl service;


    @Test
    void save_callsRepositorySave() {
        Student student = new Student();
        student.setStudentId(1);
        service.createStudent(student);
        verify(repository, times(1)).save(student);
    }

    @Test
    void delete_callsRepositoryDelete() {
        Student student = new Student();
        student.setStudentId(2);
        service.delete(student);
        verify(repository, times(1)).delete(student);
    }

    @Test
    void grade_computesCorrectly() {
        int result = service.grade(3, 4, 10);
        assertEquals(22, result);
    }

    @Test
    void grade_withZeroContact_returnsAssignment() {
        int result = service.grade(5, 0, 7);
        assertEquals(7, result);
    }

    @Test
    void grade_withNegativeValues() {
        int result = service.grade(-2, 3, 5);
        assertEquals(-1, result);
    }
}