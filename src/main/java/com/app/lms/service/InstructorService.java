package com.app.lms.service;

import com.app.lms.dto.InstructorResponse;

import java.util.List;

public interface InstructorService {
    List<InstructorResponse> getAllInstructors();
    InstructorResponse getInstructorById(Long instructorId);
}
