package com.studentmanagement.repository.Impl;

import com.studentmanagement.model.Course;
import com.studentmanagement.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @Override
    public Course findById(Integer id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return List.of();
    }
}
