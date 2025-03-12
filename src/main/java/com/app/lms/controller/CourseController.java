package com.app.lms.controller;

import com.app.lms.dto.CourseRequest;
import com.app.lms.dto.CourseResponse;
import com.app.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("")
    public ResponseEntity<?> getAllCourses() {
        List<CourseResponse> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody CourseRequest courseRequest, @RequestParam Long courseId) {
        CourseResponse courseResponse = courseService.saveCourse(courseRequest, courseId);
        return ResponseEntity.ok(courseResponse);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable Long courseId) {
        CourseResponse courseDTO = courseService.getCourseById(courseId);
        return ResponseEntity.ok(courseDTO);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<?> editCourse(@PathVariable Long courseId, @RequestBody CourseRequest courseRequest) {
        CourseResponse courseResponse = courseService.updateCourse(courseRequest);
        return ResponseEntity.ok(courseResponse);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{courseId}/enroll")
    public ResponseEntity<?> enrollStudent(@PathVariable Long courseId, @RequestParam Long studentId) {
        courseService.enrollStudent(courseId, studentId);
        return ResponseEntity.ok().build();
    }



}
