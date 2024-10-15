package com.app.lms.controller;

import com.app.lms.dto.CourseDTO;
import com.app.lms.dto.CreateCourseDTO;
import com.app.lms.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCourses() {
        List<CourseDTO> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody CreateCourseDTO createCourseDTO, @RequestParam Long id) {
        CourseDTO courseDTO = courseService.saveCourse(createCourseDTO, id);
        return ResponseEntity.ok(courseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        CourseDTO courseDTO = courseService.getCourseById(id);
        return ResponseEntity.ok(courseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCourse(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        courseDTO = courseService.updateCourse(courseDTO);
        return ResponseEntity.ok(courseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/enroll")
    public ResponseEntity<?> enrollStudent(@PathVariable Long id, @RequestParam Long studentId) {
        courseService.enrollStudent(id, studentId);
        return ResponseEntity.ok().build();
    }
}
