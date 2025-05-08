package com.app.lms.service;

import com.app.lms.dto.RegistrationRequest;
import com.app.lms.dto.RegistrationResponse;
import com.app.lms.entity.User;
import com.app.lms.exception.ErrorCode;
import com.app.lms.exception.custom.ValidationException;
import com.app.lms.repository.UserRepository;
import com.app.lms.utils.ValidationChecks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ValidationChecks validationChecks;


    @Override
    public void register(RegistrationRequest registrationRequest) {
        try {
            if(validationChecks.isUserPresent(registrationRequest.getEmail())) {
                throw new ValidationException("User already exists", ErrorCode.USER_ALREADY_EXISTS);
            }
            if (!validationChecks.isValidEmail(registrationRequest.getEmail())) {
                throw new ValidationException("Invalid email", ErrorCode.INVALID_EMAIL);
            }
            if (!validationChecks.isValidPassword(registrationRequest.getPassword())) {
                throw new ValidationException("Invalid password", ErrorCode.INVALID_PASSWORD);
            }
            User user = User.builder()
                    .email(registrationRequest.getEmail())
                    .password(registrationRequest.getPassword())
                    .username(registrationRequest.getUsername())
                    .profilePictureUrl(registrationRequest.getProfilePictureUrl())
                    .build();
            userRepository.save(user);
        } catch (ValidationException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Internal server error");
        }
    }
}
