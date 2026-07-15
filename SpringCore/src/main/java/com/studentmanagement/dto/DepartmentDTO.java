package com.studentmanagement.dto;

import com.studentmanagement.enums.Specialization;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
public class DepartmentDTO {
    private Integer id;
    private Specialization name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Specialization getName() {
        return name;
    }

    public void setName(Specialization name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
