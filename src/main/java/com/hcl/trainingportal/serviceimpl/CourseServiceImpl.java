package com.hcl.trainingportal.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.trainingportal.dto.CourseResponseDTO;
import com.hcl.trainingportal.dto.ResponseDTO;
import com.hcl.trainingportal.entity.Course;
import com.hcl.trainingportal.repository.CourseRepository;
import com.hcl.trainingportal.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	@Override
	public ResponseDTO getAllCourses() {
		
		ResponseDTO responseDTO = new ResponseDTO();
		List<Course> courseList = courseRepository.findAll();
		List<CourseResponseDTO> courseResponseDTOList = courseList.stream().map(i -> new CourseResponseDTO(i.getCourseId(), i.getCourseName() , i.getDescription())).collect(Collectors.toList());
		responseDTO.setHttpStatus(HttpStatus.OK);
		responseDTO.setMessage("List of Courses");
		responseDTO.setData(courseResponseDTOList);
		return responseDTO;
	}

}
