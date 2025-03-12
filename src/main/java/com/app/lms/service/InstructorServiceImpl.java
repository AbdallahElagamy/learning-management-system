package com.app.lms.service;

import com.app.lms.dto.InstructorResponse;
import com.app.lms.entity.Instructor;
import com.app.lms.exception.custom.ResourceNotFoundException;
import com.app.lms.mapper.InstructorMapper;
import com.app.lms.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    @Override
    public InstructorResponse getInstructorById(Long instructorId) {
        try {
            Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));
            return instructorMapper.toInstructorResponse(instructor);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Instructor not found");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the instructor");
        }
    }

    @Override
    public List<InstructorResponse> getAllInstructors() {
        try {
            List<Instructor> instructors = instructorRepository.findAll();
            return instructors.stream()
                    .map(instructorMapper::toInstructorResponse)
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching the instructors");
        }
    }
}
