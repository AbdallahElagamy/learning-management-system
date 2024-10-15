package com.app.lms.service;

import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.dto.StudentDTO;
import com.app.lms.entity.enums.Role;

public interface StudentService {
    StudentDTO addStudent(RegisterUserDTO registerUserDTO);
    StudentDTO getStudentByID(Long id);
}
