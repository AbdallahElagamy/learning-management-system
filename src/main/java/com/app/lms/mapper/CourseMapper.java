package com.app.lms.mapper;

import com.app.lms.dto.CourseRequest;
import com.app.lms.dto.CourseResponse;
import com.app.lms.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseResponse toCourseResponse(Course course);

    Course toCourse(CourseRequest courseRequest);
}
