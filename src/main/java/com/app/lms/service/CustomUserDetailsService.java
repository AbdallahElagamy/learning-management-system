package com.app.lms.service;

import com.app.lms.entity.User;
import com.app.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        else {
            User userDetails = user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userDetails.getEmail())
                    .password(userDetails.getPassword())
                    .authorities(userDetails.getRole().toString())
                    .build();
        }
    }
}
