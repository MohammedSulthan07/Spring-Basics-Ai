package com.studentmanagement.service.Impl;

import com.studentmanagement.dto.CourseDTO;
import com.studentmanagement.model.Course;
import com.studentmanagement.repository.CourseRepository;
import com.studentmanagement.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public CourseDTO findById(Integer id) {

        return null;
    }

    @Override
    public List<CourseDTO> findAll() {

        return List.of();
    }
}
