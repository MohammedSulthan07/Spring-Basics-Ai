package com.studentmanagement.util;

import com.studentmanagement.dto.CourseDTO;
import com.studentmanagement.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseDTO courseDTO);

    CourseDTO toDto(Course course);

}
