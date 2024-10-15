package com.app.lms.mapper;

import com.app.lms.dto.InstructorDTO;
import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorDTO toInstructorDTO(Instructor instructor);
    Instructor toInstructor(InstructorDTO instructorDTO);
    Instructor toInstructor(RegisterUserDTO registerUserDTO);
}
