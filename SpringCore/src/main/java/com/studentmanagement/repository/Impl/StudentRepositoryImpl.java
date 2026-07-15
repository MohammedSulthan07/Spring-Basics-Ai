package com.studentmanagement.repository.Impl;

import com.studentmanagement.enums.Gender;
import com.studentmanagement.enums.Specialization;
import com.studentmanagement.exception.StudentNotFoundException;
import com.studentmanagement.model.Address;
import com.studentmanagement.model.Course;
import com.studentmanagement.enums.CourseType;
import com.studentmanagement.model.Department;
import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class   StudentRepositoryImpl implements StudentRepository {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Student student) {
        try (Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
        }
    }

    @Override
    public void update(int studentId, String courseName) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.find(Student.class, studentId);
            if (student != null) {
                for (Course course : student.getCourse()) {
                    course.setCourseName(courseName);
                }
                session.merge(student);
            }
            tx.commit();
        }
    }

    @Override
    public void deleteById(Integer studentId) {
        try (Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();
            Student student=session.find(Student.class,studentId);
            session.remove(student);
            tx.commit();
        }catch (Exception e){
            throw new StudentNotFoundException(e.getMessage());
        }
    }

    @Override
    public Optional<Student> findById(Integer studentId) {
        try (Session session = sessionFactory.openSession()) {
            Student student = session.find(Student.class, studentId);
            Hibernate.initialize(student.getCourse());
            return Optional.ofNullable(student);
        }
    }

    @Override
    public List<Student> findAll() {
        String hql = "SELECT o FROM Student o";
        try (Session session = sessionFactory.openSession()) {
            return session.createSelectionQuery(hql, Student.class)
                    .getResultList();
        }
    }
}
