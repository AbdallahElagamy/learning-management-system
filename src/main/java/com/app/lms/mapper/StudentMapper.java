package com.app.lms.mapper;

import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.dto.StudentDTO;
import com.app.lms.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDTO toStudentDTO(Student student);
    Student toStudent(StudentDTO studentDTO);
    Student toStudent(RegisterUserDTO registerUserDTO);
}
