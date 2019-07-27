package com.hcl.trainingportal.serviceimpl;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trainingportal.dto.TraineeDTO;
import com.hcl.trainingportal.exception.ApplicationException;
import com.hcl.trainingportal.repository.TraineeRepository;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceImplTest {

	@InjectMocks
	RegisterServiceImpl registerServiceImpl;
	
	@Mock
	TraineeRepository traineeRepository;
	
	TraineeDTO traineeDTO;
	
	@Before
	public void setUp() {
		traineeDTO = new TraineeDTO();
	}
	
	@Test
	public void testRegisterUserIfTraineeDetailsAreCorrect() throws ApplicationException  {
		
		assertNull(registerServiceImpl.registerUser(traineeDTO));
	}
}
