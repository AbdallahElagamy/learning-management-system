package com.app.lms.service;

import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.dto.UserDTO;
import com.app.lms.entity.enums.Role;
import com.app.lms.mapper.UserMapper;
import com.app.lms.repository.InstructorRepository;
import com.app.lms.repository.StudentRepository;
import com.app.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final InstructorRepository InstructorRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO addUser(RegisterUserDTO registerUserDTO, Role role) {
        return null;
    }
}
