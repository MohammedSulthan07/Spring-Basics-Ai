package com.studentmanagement.service;

import com.studentmanagement.dto.CourseDTO;
import com.studentmanagement.model.Course;

import java.util.List;

public interface CourseService {

    CourseDTO findById(Integer id);

    List<CourseDTO> findAll();
}
