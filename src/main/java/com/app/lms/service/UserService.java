package com.app.lms.service;

import com.app.lms.dto.RegistrationRequest;
import com.app.lms.dto.RegistrationResponse;

public interface UserService {
    public void register(RegistrationRequest registrationRequest);
}
