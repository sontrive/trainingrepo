package com.hcl.trainingportal.service;

import com.hcl.trainingportal.dto.RequestApprovalDTO;
import com.hcl.trainingportal.dto.RequestDTO;
import com.hcl.trainingportal.dto.ResponseDTO;
import com.hcl.trainingportal.exception.ApplicationException;


public interface RequestService {
	
	public void approve(RequestApprovalDTO requestDto) throws ApplicationException;
	
	public ResponseDTO raiseRequest(RequestDTO requestDTO) throws ApplicationException;

}
