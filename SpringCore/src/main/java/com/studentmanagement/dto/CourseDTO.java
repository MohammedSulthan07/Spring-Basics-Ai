package com.studentmanagement.dto;

import com.studentmanagement.enums.CourseType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

//@Getter
//@Setter
//@ToString
public class CourseDTO {
    private Integer id;
    private String courseName;
    private Double fee;
    private Integer duration;
    private LocalDate courseEnrollmentDate;
    private CourseType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getCourseEnrollmentDate() {
        return courseEnrollmentDate;
    }

    public void setCourseEnrollmentDate(LocalDate courseEnrollmentDate) {
        this.courseEnrollmentDate = courseEnrollmentDate;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", fee=" + fee +
                ", duration=" + duration +
                ", courseEnrollmentDate=" + courseEnrollmentDate +
                ", type=" + type +
                '}';
    }
}
