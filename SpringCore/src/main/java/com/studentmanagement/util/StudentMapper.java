package com.studentmanagement.util;

import com.studentmanagement.dto.StudentDTO;
import com.studentmanagement.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "department",source = "departmentDTO")
    @Mapping(target = "course",source ="courseDTO" )
    @Mapping(target = "address",source = "addressDTO")
    Student toEntity(StudentDTO dto);

    @Mapping(target = "departmentDTO",source = "department")
    @Mapping(target = "courseDTO",source = "course")
    @Mapping(target = "addressDTO",source = "address")
    StudentDTO toDto(Student entity);
}
