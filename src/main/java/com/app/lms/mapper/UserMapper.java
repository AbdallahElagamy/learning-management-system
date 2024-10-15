package com.app.lms.mapper;

import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.dto.UserDTO;
import com.app.lms.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
    User toUser(RegisterUserDTO createUserDTO);
}
