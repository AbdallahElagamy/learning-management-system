package com.app.lms.utils;

import com.app.lms.entity.User;
import com.app.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ValidationChecks {

    private final UserRepository userRepository;

    public boolean isUserPresent(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        return userOptional.isPresent();
    }

    public boolean isValidEmail(String email) {
        String requiredDomain = "@gmail.com";
        return email != null && email.endsWith(requiredDomain);
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }




}
