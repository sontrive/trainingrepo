package com.hcl.trainingportal.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trainingportal.service.CourseService;

@RunWith(MockitoJUnitRunner.class)
public class CourseControllerTest {

	@InjectMocks
	CourseController courseController;
	
	@Mock
	CourseService courseService;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testGetAllCoursesIfCoursesArePresent() {
		
		assertNotNull(courseController.getAllCourses());
	}
}
