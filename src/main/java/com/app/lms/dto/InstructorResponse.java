package com.app.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InstructorDTO {
    private String email;
    private String username;
    private String password;
    private String contactInformation;
}
