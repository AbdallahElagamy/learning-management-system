package com.app.lms.mapper;

import com.app.lms.dto.CourseDTO;
import com.app.lms.dto.CreateCourseDTO;
import com.app.lms.entity.Course;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseDTO toCourseDTO(Course course);
    Course toCourse(CourseDTO courseDTO);
    CreateCourseDTO toCreateDTO(Course course);
    Course toCourse(CreateCourseDTO createCourseDTO);
}
