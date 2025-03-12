package com.app.lms.service;

import com.app.lms.dto.StudentResponse;
import com.app.lms.entity.Student;
import com.app.lms.exception.custom.ResourceNotFoundException;
import com.app.lms.mapper.StudentMapper;
import com.app.lms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentResponse> getAllStudents() {
        try {
            List<Student> students = studentRepository.findAll();
            return students.stream()
                    .map(studentMapper::toStudentResponse)
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the students");
        }
    }

    @Override
    public StudentResponse getStudentByID(Long studentId) {
        try {
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
            return studentMapper.toStudentResponse(student);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Student not found");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the student");
        }
    }
}
