package com.hcl.trainingportal.serviceimpl;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trainingportal.dto.RequestApprovalDTO;
import com.hcl.trainingportal.repository.RequestRepository;

@RunWith(MockitoJUnitRunner.class)
public class RequestServiceImplTest {

	@InjectMocks
	RequestServiceImpl requestServiceImpl;
	
	@Mock
	RequestRepository requestRepository;
	
	RequestApprovalDTO requestDto;
	
	@Before
	public void setUp() {
		requestDto = new RequestApprovalDTO();
	}
	
	
}
