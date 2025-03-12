package com.app.lms.controller;

import com.app.lms.dto.CourseRequest;
import com.app.lms.dto.CourseResponse;
import com.app.lms.entity.Course;
import com.app.lms.service.CourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CourseControllerTest {


    @Test
    public void testGetCourseById() {

    }

}
