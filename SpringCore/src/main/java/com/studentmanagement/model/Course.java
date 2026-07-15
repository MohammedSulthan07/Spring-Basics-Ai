package com.studentmanagement.model;

import com.studentmanagement.enums.CourseType;
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
@Table(name = "course_table")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false)
    private Double fee;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private LocalDate courseEnrollmentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CourseType type;

    @ManyToMany(mappedBy = "course")
    private Set<Student> students = new HashSet<>();

    public Course(Integer id, String courseName, Double fee, Integer duration, LocalDate courseEnrollmentDate, CourseType type) {
        this.id = id;
        this.courseName = courseName;
        this.fee = fee;
        this.duration = duration;
        this.courseEnrollmentDate = courseEnrollmentDate;
        this.type = type;
    }
}
