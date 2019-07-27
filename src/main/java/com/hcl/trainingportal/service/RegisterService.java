package com.hcl.trainingportal.service;

import com.hcl.trainingportal.dto.ResponseDTO;
import com.hcl.trainingportal.dto.TraineeDTO;
import com.hcl.trainingportal.exception.ApplicationException;

public interface RegisterService {
	
	public ResponseDTO registerUser(TraineeDTO traineeDTO) throws ApplicationException;
	


}
