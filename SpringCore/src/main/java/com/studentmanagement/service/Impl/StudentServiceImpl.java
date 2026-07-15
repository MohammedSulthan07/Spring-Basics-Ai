package com.studentmanagement.service.Impl;

import com.studentmanagement.dto.StudentDTO;
import com.studentmanagement.exception.StudentNotFoundException;
import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentRepository;
import com.studentmanagement.service.StudentService;
import com.studentmanagement.util.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    @Value("${student.not.found}")
    private String studentNotFound;

    @Override
    public void save(StudentDTO studentDTO) {
        Student student=studentMapper.toEntity(studentDTO);
        studentRepository.save(student);
    }

    @Override
    public void update(int studentId, String courseName) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isEmpty()) {
            throw new StudentNotFoundException(studentNotFound);
        }
        studentRepository.update(studentId, courseName);
    }

    @Override
    public void deleteById(Integer studentId) {
        Optional<Student> optionalStudent=studentRepository.findById(studentId);
        studentRepository.deleteById(studentId);

    }

    @Override
    public StudentDTO findById(Integer studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentNotFound));
        return studentMapper.toDto(student);
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(studentMapper::toDto).toList();
    }
}
