package com.hcl.trainingportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainingportal.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@GetMapping("")
	public ResponseEntity<Object> getAllCourses(){
		return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
	}
}
