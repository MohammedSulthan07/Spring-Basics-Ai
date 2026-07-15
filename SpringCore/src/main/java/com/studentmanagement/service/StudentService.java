package com.studentmanagement.service;

import com.studentmanagement.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    void save(StudentDTO studentDTO);

    void update(int studentId, String courseName);

    void deleteById(Integer studentId);

    StudentDTO findById(Integer studentId);

    List<StudentDTO> findAll();
}
