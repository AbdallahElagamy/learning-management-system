package com.app.lms.service;

import com.app.lms.dto.CourseDTO;
import com.app.lms.dto.CreateCourseDTO;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream()
                .map(courseMapper::toCourseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isEmpty()) {
            throw new ResourceNotFoundException("Course not found");
        }
        return courseMapper.toCourseDTO(course.get());
    }

    @Override
    public CourseDTO saveCourse(CreateCourseDTO createCourseDTO, long id) {
        Optional<Instructor> instructor = instructorRepository.findById(id);
        if(instructor.isEmpty()) {
            throw new ResourceNotFoundException("Instructor not found");
        }
        Course course = courseMapper.toCourse(createCourseDTO);
        course.setInstructor(instructor.get());
        courseRepository.save(course);
        return courseMapper.toCourseDTO(course);
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        Course course = courseMapper.toCourse(courseDTO);
        courseRepository.save(course);
        return courseMapper.toCourseDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void enrollStudent(Long courseId, Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if(student.isEmpty()) {
            throw new ResourceNotFoundException("Student not found");
        }
        Optional<Course> course = courseRepository.findById(courseId);
        if(course.isEmpty()) {
            throw new ResourceNotFoundException("Course not found");
        }
        course.get().getStudents().add(student.get());
        courseRepository.save(course.get());
    }
}
