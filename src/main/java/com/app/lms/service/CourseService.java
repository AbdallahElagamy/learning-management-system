package com.app.lms.service;

import com.app.lms.dto.CourseRequest;
import com.app.lms.dto.CourseResponse;


import java.util.List;

public interface CourseService {
    List<CourseResponse> getAllCourses();
    CourseResponse getCourseById(Long id);
    CourseResponse saveCourse(CourseRequest courseRequest, Long instructorId);
    CourseResponse updateCourse(CourseRequest courseRequest);
    void deleteCourse(Long courseId);
    void enrollStudent(Long courseId, Long studentId);
}
