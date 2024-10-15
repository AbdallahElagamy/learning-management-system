package com.app.lms.service;

import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.dto.UserDTO;
import com.app.lms.entity.enums.Role;

public interface UserService {
    UserDTO addUser(RegisterUserDTO registerUserDTO, Role role);
}
