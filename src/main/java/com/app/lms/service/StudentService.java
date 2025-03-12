package com.app.lms.service;

import com.app.lms.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAllStudents();
    StudentResponse getStudentByID(Long studentId);
}
