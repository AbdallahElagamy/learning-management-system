package com.app.lms.service;

import com.app.lms.dto.InstructorDTO;
import com.app.lms.dto.RegisterUserDTO;

import java.util.List;

public interface InstructorService {
    InstructorDTO addInstructor(RegisterUserDTO registerUserDTO);
    InstructorDTO getInstructorById(Long id);
}
