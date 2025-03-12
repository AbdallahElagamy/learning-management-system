package com.app.lms.service;

import com.app.lms.dto.CourseRequest;
import com.app.lms.dto.CourseResponse;
import com.app.lms.entity.Course;
import com.app.lms.entity.Instructor;
import com.app.lms.entity.Student;
import com.app.lms.exception.custom.ResourceNotFoundException;
import com.app.lms.mapper.CourseMapper;
import com.app.lms.repository.CourseRepository;
import com.app.lms.repository.InstructorRepository;
import com.app.lms.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseResponse> getAllCourses() {
        try {
            List<Course> courses = courseRepository.findAll();
            return courses.stream()
                    .map(courseMapper::toCourseResponse)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResourceNotFoundException("Courses not found");
        }
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        try {
            Course course = courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
            return courseMapper.toCourseResponse(course);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Course not found");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching course");
        }
    }

    @Override
    public CourseResponse saveCourse(CourseRequest courseRequest, Long instructorId) {
        try {
            Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));
            Course course = courseMapper.toCourse(courseRequest);
            course.setInstructor(instructor);
            courseRepository.save(course);
            return courseMapper.toCourseResponse(course);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Instructor not found");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while saving course");
        }
    }

    @Override
    public CourseResponse updateCourse(CourseRequest courseRequest) {
        try {
            Course course = courseMapper.toCourse(courseRequest);
            courseRepository.save(course);
            return courseMapper.toCourseResponse(course);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while updating course");
        }
    }

    @Override
    public void deleteCourse(Long courseId) {
        try {
            courseRepository.deleteById(courseId);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting course");
        }
    }

    @Override
    public void enrollStudent(Long courseId, Long studentId) {
        try {
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
            Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
            course.getStudents().add(student);
            courseRepository.save(course);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Resource not found");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while enrolling student");
        }
    }
}
