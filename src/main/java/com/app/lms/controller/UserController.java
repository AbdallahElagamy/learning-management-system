package com.app.lms.controller;

import com.app.lms.dto.RegisterUserDTO;
import com.app.lms.entity.enums.Role;
import com.app.lms.service.InstructorService;
import com.app.lms.service.StudentService;
import com.app.lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;
    private final StudentService studentService;
    private final InstructorService instructorService;

    @Autowired
    public UserController(UserService userService,
                          StudentService studentService,
                          InstructorService instructorService) {
        this.userService = userService;
        this.studentService = studentService;
        this.instructorService = instructorService;
    }

    @PostMapping("/register-student")
    public ResponseEntity<?> registerStudent(@RequestBody RegisterUserDTO registerUserDTO) {
        studentService.addStudent(registerUserDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register-instructor")
    public ResponseEntity<?> registerInstructor(@RequestBody RegisterUserDTO registerUserDTO) {
        instructorService.addInstructor(registerUserDTO);
        return ResponseEntity.ok().build();
    }
}
