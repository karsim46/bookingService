package com.codeclan.example.bookingService.controllers;

import com.codeclan.example.bookingService.models.Course;
import com.codeclan.example.bookingService.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> findCourses(){
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
}
