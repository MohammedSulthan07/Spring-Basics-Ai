package com.studentmanagement.repository;

import com.studentmanagement.model.Course;
import java.util.List;

public interface CourseRepository {

    Course findById(Integer id);

    List<Course> findAll();
}
