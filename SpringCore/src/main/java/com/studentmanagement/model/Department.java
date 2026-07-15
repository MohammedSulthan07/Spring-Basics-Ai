package com.studentmanagement.model;

import com.studentmanagement.enums.Specialization;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "department_table")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,unique = true)
    private Specialization name;

    @OneToMany(mappedBy = "department")
    private List<Student> students = new ArrayList<>();
    public Department(Integer id, Specialization name) {
        this.id = id;
        this.name = name;
    }
}
