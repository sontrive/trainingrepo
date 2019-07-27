package com.hcl.trainingportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainingportal.dto.RequestApprovalDTO;
import com.hcl.trainingportal.dto.TraineeDTO;
import com.hcl.trainingportal.exception.ApplicationException;
import com.hcl.trainingportal.service.RequestService;

@RestController
public class RequestController {

private static final String ERROR_MSG = "Mandetory Element missing : ";
	
	@Autowired
	RequestService requestService;
	
	@PostMapping("/trainner/approve")
	public ResponseEntity<Object> approve(@RequestBody RequestApprovalDTO requestApprovalDTO) throws ApplicationException {
		if(requestApprovalDTO.getTrainerId() == null || requestApprovalDTO.getRequestId() == 0) {
			throw new ApplicationException("Trainer id is not valid");
		}
		
		//return new ResponseEntity<>(requestService.registerUser(traineeDTO), HttpStatus.OK);
		return null;
	}
}
