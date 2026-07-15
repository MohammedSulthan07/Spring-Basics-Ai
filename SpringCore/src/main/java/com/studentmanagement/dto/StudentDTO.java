package com.studentmanagement.dto;

import com.studentmanagement.enums.Gender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
public class StudentDTO {
    private Integer id;
    private String name;
    private String regNo;
    private Gender gender;
    private LocalDate dateOfBirth;
    private Integer age;
    private String email;
    private String mobileNumber;
    private AddressDTO addressDTO;
    private DepartmentDTO departmentDTO;
    private Set<CourseDTO> courseDTO=new HashSet<>();
}
