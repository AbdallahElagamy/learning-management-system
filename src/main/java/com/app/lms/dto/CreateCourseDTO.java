package com.app.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCourseDTO {
    private String title;
    private String description;
    private String category;
    private BigDecimal price;
    private double rating;
}
