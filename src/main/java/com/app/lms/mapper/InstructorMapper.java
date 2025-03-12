package com.app.lms.mapper;

import com.app.lms.dto.InstructorResponse;
import com.app.lms.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorResponse toInstructorResponse(Instructor instructor);

    Instructor toInstructor(InstructorResponse instructorResponse);
}
