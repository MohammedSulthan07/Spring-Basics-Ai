package com.studentmanagement.model;


import com.studentmanagement.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,unique = true)
    private String regNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false,unique = true,length = 10)
    private String mobileNumber;

    @OneToOne(cascade = CascadeType.ALL,optional = false,orphanRemoval = true)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany(cascade ={ CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id")
            ,inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> course = new HashSet<>();

    public Student(Integer id, String name, String regNo, Gender gender, LocalDate dateOfBirth, Integer age, String email, String mobileNumber, Address address, Department department, Set<Course> course) {
        this.id = id;
        this.name = name;
        this.regNo = regNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.department = department;
        this.course = course;
    }
}
