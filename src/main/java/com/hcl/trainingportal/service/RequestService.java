package com.hcl.trainingportal.service;

import com.hcl.trainingportal.dto.RequestDTO;
import com.hcl.trainingportal.exception.ApplicationException;


public interface RequestService {
	
	public void approve(RequestDTO requestDto) throws ApplicationException;

}
