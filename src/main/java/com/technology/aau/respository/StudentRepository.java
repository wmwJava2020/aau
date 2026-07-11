package com.technology.aau.respository;

import com.technology.aau.entity.Student;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    void deleteById(@Nonnull Long id);
}
