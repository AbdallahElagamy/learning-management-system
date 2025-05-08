package com.app.lms.controller;

import com.app.lms.dto.RegistrationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest registrationRequest) {
        return "User registered successfully";
    }
}
