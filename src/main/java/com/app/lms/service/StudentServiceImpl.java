package com.app.lms.service;

import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.dto.StudentDTO;
import com.app.lms.entity.Student;
import com.app.lms.entity.enums.Role;
import com.app.lms.exception.custom.ResourceNotFoundException;
import com.app.lms.mapper.StudentMapper;
import com.app.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDTO addStudent(RegisterUserDTO registerUserDTO) {
        Student student = studentMapper.toStudent(registerUserDTO);
        student.setRegistrationDate(Timestamp.from(Instant.now()));
        student.setRole(Role.STUDENT);
        studentRepository.save(student);
        return studentMapper.toStudentDTO(student);
    }

    @Override
    public StudentDTO getStudentByID(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            throw new ResourceNotFoundException("Student not found");
        }
        return studentMapper.toStudentDTO(student.get());
    }
}
