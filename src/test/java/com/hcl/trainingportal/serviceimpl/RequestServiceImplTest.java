package com.hcl.trainingportal.serviceimpl;


import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trainingportal.dto.RequestApprovalDTO;
import com.hcl.trainingportal.entity.Request;
import com.hcl.trainingportal.exception.ApplicationException;
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
	
	@Test
	public void testApproveIfRequestApprovalIsPresent() throws ApplicationException {
		requestDto.setRequestId(1L);
		Request request = new Request();
		requestDto.setStatus("approved");
		requestDto.setCourseStartDate(LocalDateTime.now());
		Optional<Request> requestOpt = Optional.of(request);
		when(requestRepository.findById(requestDto.getRequestId())).thenReturn(requestOpt);
		requestServiceImpl.approve(requestDto);
	}
}
