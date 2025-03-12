package com.app.lms.mapper;

import com.app.lms.dto.StudentResponse;
import com.app.lms.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentResponse toStudentResponse(Student student);

    Student toStudent(StudentResponse studentResponse);
}
