package com.hcl.trainingportal.serviceimpl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.trainingportal.dto.RequestApprovalDTO;
import com.hcl.trainingportal.dto.RequestDTO;
import com.hcl.trainingportal.dto.ResponseDTO;
import com.hcl.trainingportal.entity.Course;
import com.hcl.trainingportal.entity.Request;
import com.hcl.trainingportal.entity.Trainee;
import com.hcl.trainingportal.exception.ApplicationException;
import com.hcl.trainingportal.repository.CourseRepository;
import com.hcl.trainingportal.repository.RequestRepository;
import com.hcl.trainingportal.repository.TraineeRepository;
import com.hcl.trainingportal.service.RequestService;
import com.hcl.trainingportal.util.RequestStatusUtil;
@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	TraineeRepository traineeRepository;

	@Override
	public void approve(RequestApprovalDTO requestDto) throws ApplicationException {
		
		Optional<Request> requestOpt = requestRepository.findById(requestDto.getRequestId());
		if(!requestOpt.isPresent()) {
			throw new ApplicationException("Request id is not found.");
		}else {
			Request request = requestOpt.get();
			request.setStatus(requestDto.getStatus());
			request.setCourseStartDate(requestDto.getCourseStartDate());
			requestRepository.save(request);
		}
		
	}
	
	@Override
	public ResponseDTO raiseRequest(RequestDTO requestDTO) throws ApplicationException {
		ResponseDTO responseDTO = new ResponseDTO();
		Request request = new Request();
		
		Optional<Course> optionalCourseId = courseRepository.findById(requestDTO.getCourseId());
		
		Course courseId;
		if(optionalCourseId.isPresent()) {
			courseId = optionalCourseId.get();
		}else {
			throw new ApplicationException("Invalid course id.");
		}
		
		Optional<Trainee> optionalTraineeId = traineeRepository.findById(requestDTO.getTraineeId());
		Trainee traineeId;
		
		if(optionalTraineeId.isPresent()) {
			traineeId = optionalTraineeId.get();
		}else {
			throw new ApplicationException("Invalid trainee id.");
		}
		
		
		request.setCourseDetails(courseId);
		request.setCourseStartDate(LocalDateTime.now());
		request.setStatus(RequestStatusUtil.PENDING);
		request.setTraineeDetails(traineeId);
		request.setTrainerDetails(courseId.getTrainer());
		
		Request saveRequest = requestRepository.save(request);
		
		responseDTO.setHttpStatus(HttpStatus.OK);
		responseDTO.setMessage("List of Courses");
		responseDTO.setData(saveRequest);
		
		return responseDTO;
	}

}
