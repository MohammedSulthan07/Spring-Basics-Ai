package com.studentmanagement.repository;

import com.studentmanagement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void save(Student student);

    void update(int studentId, String courseName);

    void deleteById(Integer studentId);

    Optional<Student> findById(Integer studentId);

    List<Student> findAll();
}
