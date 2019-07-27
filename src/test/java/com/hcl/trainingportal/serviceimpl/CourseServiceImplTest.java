package com.hcl.trainingportal.serviceimpl;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trainingportal.entity.Course;
import com.hcl.trainingportal.repository.CourseRepository;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceImplTest {

	@InjectMocks
	CourseServiceImpl courseServiceImpl;
	
	@Mock
	CourseRepository courseRepository;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testGetAllCoursesIfCoursesAreAvailable() {
		List<Course> courseList = new ArrayList<>();
		Course course = new Course();
		course.setCourseId(1L);
		course.setCourseName("Java");
		course.setDescription("Java J2EE");
		courseList.add(course);
		when(courseRepository.findAll()).thenReturn(courseList);
		assertNotNull(courseServiceImpl.getAllCourses());
	}
}
