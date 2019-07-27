package com.hcl.trainingportal.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trainingportal.dto.RequestApprovalDTO;
import com.hcl.trainingportal.exception.ApplicationException;
import com.hcl.trainingportal.service.RequestService;

@RunWith(MockitoJUnitRunner.class)
public class RequestControllerTest {

	@InjectMocks
	RequestController requestController;
	
	@Mock
	RequestService requestService;
	
	RequestApprovalDTO requestApprovalDTO;
	
	@Before
	public void setUp() {
		requestApprovalDTO = new RequestApprovalDTO();
	}
	
	@Test
	public void testApproveIfRequestApprovalDetailsArePresent() throws ApplicationException {
		requestApprovalDTO.setTrainerId(1L);
		requestApprovalDTO.setRequestId(1L);
		requestApprovalDTO.setStatus("approved");
		assertNotNull(requestController.approve(requestApprovalDTO));
	}
	
	@Test(expected = ApplicationException.class)
	public void testApproveIfTrainerIdIsNotPresent() throws ApplicationException {
		requestApprovalDTO.setTrainerId(null);
		requestApprovalDTO.setRequestId(1L);
		requestApprovalDTO.setStatus("approved");
		assertNull(requestController.approve(requestApprovalDTO));
	}
	
	@Test(expected = ApplicationException.class)
	public void testApproveIfRequestIdIsNotPresent() throws ApplicationException {
		requestApprovalDTO.setTrainerId(1L);
		requestApprovalDTO.setRequestId(0L);
		requestApprovalDTO.setStatus("approved");
		assertNull(requestController.approve(requestApprovalDTO));
	}
}
