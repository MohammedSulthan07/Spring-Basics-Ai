package com.studentmanagement.util;

import com.studentmanagement.dto.AddressDTO;
import com.studentmanagement.dto.CourseDTO;
import com.studentmanagement.dto.DepartmentDTO;
import com.studentmanagement.dto.StudentDTO;
import com.studentmanagement.enums.CourseType;
import com.studentmanagement.enums.Gender;
import com.studentmanagement.enums.Specialization;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputUtil {
    public static int acceptMenuOption(Scanner sc) {
        System.out.println("Press 1 to add new student.");
        System.out.println("Press 2 to fetch student details.");
        System.out.println("Press 3 to update course details of student.");
        System.out.println("Press 4 to delete student details.");
        System.out.println("Press 5 to find All student details.");
        int menuOption = sc.nextInt();
        if (menuOption == 1 || menuOption == 2 || menuOption == 3 || menuOption == 4||menuOption==5) {
            return menuOption;
        } else {
            return acceptMenuOption(sc);
        }
    }

    public static boolean wantToContinue(Scanner sc) {
        System.out.println("Press Y to continue and N to exit.");
        char choice = sc.next().toUpperCase().charAt(0);
        return 'Y' == choice;
    }

    public static StudentDTO acceptStudentDetailsToSave(Scanner sc) {
        System.out.println("Enter name of student:");
        String name = sc.next();

        System.out.println("Enter registration number:");
        String regNo = sc.next();

        System.out.println("Enter gender of student:" + Arrays.asList(Gender.values()));
        String gender = sc.next().toUpperCase();

        System.out.println("Enter date of birth (dd-MM-yyyy):");
        String dateOfBirth = sc.next();

        System.out.println("Enter age of student:");
        int age = sc.nextInt();

        System.out.println("Enter email id of student:");
        String email = sc.next();

        System.out.println("Enter mobile number of student:");
        String mobileNumber = sc.next();

        // ---- Department ----
        System.out.println("Enter department specialization:" + Arrays.asList(Specialization.values()));
        String specialization = sc.next().toUpperCase();

        // ---- Address ----
        System.out.println("Enter city:");
        String city = sc.next();
        System.out.println("Enter state:");
        String state = sc.next();
        System.out.println("Enter country:");
        String country = sc.next();
        System.out.println("Enter pincode:");
        String pincode = sc.next();

        // ---- Course ----
        sc.nextLine();
        System.out.println("Enter course name:");
        String courseName = sc.nextLine();
        System.out.println("Enter course fee:");
        double fee = sc.nextDouble();
        System.out.println("Enter course duration (in months):");
        int duration = sc.nextInt();
        System.out.println("Enter course enrollment date (dd-MM-yyyy):");
        String courseEnrollmentDate = sc.next();
        System.out.println("Enter course type:" + Arrays.asList(CourseType.values()));
        String courseType = sc.next().toUpperCase();

        try {
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setCity(city);
            addressDTO.setState(state);
            addressDTO.setCountry(country);
            addressDTO.setPincode(pincode);

            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setName(Specialization.valueOf(specialization));

            Set<CourseDTO> courses=new HashSet<>();
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCourseName(courseName);
            courseDTO.setFee(fee);
            courseDTO.setDuration(duration);
            courseDTO.setCourseEnrollmentDate(convertStringToDate(courseEnrollmentDate));
            courseDTO.setType(CourseType.valueOf(courseType));
            courses.add(courseDTO);

            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setName(name);
            studentDTO.setRegNo(regNo);
            studentDTO.setGender(Gender.valueOf(gender));
            studentDTO.setDateOfBirth(convertStringToDate(dateOfBirth));
            studentDTO.setAge(age);
            studentDTO.setEmail(email);
            studentDTO.setMobileNumber(mobileNumber);
            studentDTO.setDepartmentDTO(departmentDTO);
            studentDTO.setAddressDTO(addressDTO);
            studentDTO.setCourseDTO(courses);

            return studentDTO;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return acceptStudentDetailsToSave(sc);
        }
    }

    private static LocalDate convertStringToDate(String dateOfBirth) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(dateOfBirth, format);
    }

    public static int acceptStudentIdToOperate(Scanner sc) {
        System.out.println("Enter id of student:");
        return sc.nextInt();
    }
    public static int acceptCourseIdToOperate(Scanner sc) {
        System.out.println("Enter id of student:");
        return sc.nextInt();
    }

    public static String acceptCourseDetailsToUpdate(Scanner scanner) {
        System.out.println("Enter updated name of course:");
        return scanner.next();
    }
}
