package com.app.lms.service;

import com.app.lms.dto.InstructorDTO;
import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.entity.Instructor;
import com.app.lms.entity.enums.Role;
import com.app.lms.exception.custom.ResourceNotFoundException;
import com.app.lms.mapper.InstructorMapper;
import com.app.lms.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    @Override
    public InstructorDTO addInstructor(RegisterUserDTO registerUserDTO) {
        Instructor instructor = instructorMapper.toInstructor(registerUserDTO);
        instructor.setRegistrationDate(Timestamp.from(Instant.now()));
        instructor.setRole(Role.STUDENT);
        instructorRepository.save(instructor);
        return instructorMapper.toInstructorDTO(instructor);
    }

    @Override
    public InstructorDTO getInstructorById(Long id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        if (instructor.isEmpty()) {
            throw new ResourceNotFoundException("Istructor Not Found");
        }
        return instructorMapper.toInstructorDTO(instructor.get());
    }
}
