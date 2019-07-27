package com.hcl.trainingportal.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trainingportal.dto.RequestApprovalDTO;
import com.hcl.trainingportal.entity.Request;
import com.hcl.trainingportal.exception.ApplicationException;
import com.hcl.trainingportal.repository.RequestRepository;
import com.hcl.trainingportal.service.RequestService;
@Service
public class RequestServiceImpl implements RequestService {
	
	@Autowired
	RequestRepository requestRepository;

	@Override
	public void approve(RequestApprovalDTO requestDto) throws ApplicationException {
		
		Optional<Request> requestOpt = requestRepository.findById(requestDto.getRequestId());
		if(requestOpt.isPresent()) {
			throw new ApplicationException("Request id is not found.");
		}else {
			Request request = requestOpt.get();
			request.setStatus(requestDto.getStatus());
			request.setCourseStartDate(requestDto.getCourseStartDate());
			requestRepository.save(request);
		}
		
	}

}
