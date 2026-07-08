package com.technology.aau.service;

import com.technology.aau.dto.StudentResponse;
import com.technology.aau.entity.Student;
import com.technology.aau.respository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest implements StudentService {

    @InjectMocks
    private StudentServiceImpl service;

    @Mock
    private StudentRepository studentRepository;

    private ModelMapper modelMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    @BeforeEach
    void setup() {
        modelMapper = new ModelMapper();
        studentService = new StudentServiceImpl(modelMapper, studentRepository);
    }

    @Test
    void testCreateStudent() {
        // Arrange
        Student req = new Student();
        req.setFirstName("BEAKAL");
        req.setLastName("MESSELE");
        req.setEmail("beaka@gmail.com");
        req.setPassword("passWord!");

        Student saved = new Student();
        saved.setStudentId(1);
        saved.setFirstName("BEAKAL");
        saved.setLastName("MESSELE");
        saved.setEmail("beaka@gmail.com");
        saved.setPassword("passWord!");

        when(studentRepository.save(any(Student.class))).thenReturn(saved);

        // Act
        StudentResponse response = studentService.createStudent(req);

        // Assert
        assertNotNull(response);
        assertEquals(saved.getStudentId(), response.getStudentId());
        assertEquals("BEAKAL", response.getFirstName());
        assertEquals("MESSELE", response.getLastName());
        assertEquals("beaka@gmail.com", response.getEmail());

        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void testDeleteStudent() {
        // Arrange
        Student student = new Student();
        student.setStudentId(2);

        // Act
        studentService.delete(student);

        // Assert
        verify(studentRepository, times(1)).delete(student);
    }

    @Test
    void testGradeCalculation() {
        int creditHours = 3;
        int contactHours = 4;
        int assignmentScore = 20;

        int result = studentService.grade(creditHours, contactHours, assignmentScore, "ACTIVE");

        assertNotEquals((creditHours * contactHours) + assignmentScore, result);
    }

    @Override
    public StudentResponse createStudent(Student request) {
        return null;
    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public int grade(int creditHours, int contactHours, int assignmentScore, String status) {
        return 0;
    }
}
