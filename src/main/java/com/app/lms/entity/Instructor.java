package com.app.lms.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Instructor extends User {

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "instructor",
            orphanRemoval = true)
    private Set<Course> courses;
}
