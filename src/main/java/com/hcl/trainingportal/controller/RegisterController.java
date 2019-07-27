package com.hcl.trainingportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trainingportal.dto.TraineeDTO;
import com.hcl.trainingportal.exception.ApplicationException;
import com.hcl.trainingportal.service.RegisterService;


@RestController
public class RegisterController {
	
	private static final String ERROR_MSG = "Mandetory Element missing : ";
	
	@Autowired
	RegisterService registerService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody TraineeDTO traineeDTO) throws ApplicationException {
		validateUser(traineeDTO);
		return new ResponseEntity<>(registerService.registerUser(traineeDTO), HttpStatus.OK);
	}

	private void validateUser(TraineeDTO traineeDTO) throws ApplicationException {

		if (StringUtils.isEmpty(traineeDTO.getName())) {
			throw new ApplicationException(ERROR_MSG + "Name");
		}
		if (StringUtils.isEmpty(traineeDTO.getPhoneNumber())) {
			throw new ApplicationException(ERROR_MSG + "Phone number");
		}
		if (StringUtils.isEmpty(traineeDTO.getEmail())) {
			throw new ApplicationException(ERROR_MSG + "Email");
		}

	}


	

}
