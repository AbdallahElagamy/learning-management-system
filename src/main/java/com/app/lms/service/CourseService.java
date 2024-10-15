package com.app.lms.service;

import com.app.lms.dto.CourseDTO;
import com.app.lms.dto.CreateCourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses();
    CourseDTO getCourseById(Long id);
    CourseDTO saveCourse(CreateCourseDTO createCourseDTO, long id);
    CourseDTO updateCourse(CourseDTO courseDTO);
    void deleteCourse(Long id);
    void enrollStudent(Long courseId, Long studentId);
}
