package com.hcl.trainingportal.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.trainingportal.dto.ResponseDTO;
import com.hcl.trainingportal.dto.TraineeDTO;
import com.hcl.trainingportal.entity.Trainee;
import com.hcl.trainingportal.exception.ApplicationException;
import com.hcl.trainingportal.repository.TraineeRepository;
import com.hcl.trainingportal.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	
	@Autowired
	TraineeRepository traineeRepository;
	
	public ResponseDTO registerUser(TraineeDTO traineeDTO) throws ApplicationException {
		
		ResponseDTO responseDTO= new ResponseDTO();
		
		if (null != traineeDTO) {
	
		Trainee trainee = new Trainee();
		BeanUtils.copyProperties(traineeDTO, trainee);
		Trainee savedtrainee = traineeRepository.save(trainee);
 
		responseDTO.setHttpStatus(HttpStatus.OK);
	    responseDTO.setMessage("Trainee sucessfully registered with the id"+"  "+ savedtrainee.getTraineeId());
	    responseDTO.setData("");
	     return responseDTO;
		}
		
		throw new ApplicationException("Invalid input");
	
	}

}
