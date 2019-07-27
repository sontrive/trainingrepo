package com.hcl.trainingportal.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trainingportal.dto.TraineeDTO;
import com.hcl.trainingportal.exception.ApplicationException;
import com.hcl.trainingportal.serviceimpl.RegisterServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class RegisterControllerTest {

	@InjectMocks
	RegisterController registerController;
	
	@Mock
	RegisterServiceImpl registerServiceImpl;
	
	TraineeDTO traineeDTO;
	
	@Before
	public void setUp() {
		traineeDTO = new TraineeDTO();
	}
	
	@Test
	public void testRegisterUserIfTraineeDetailsAreCorrect() throws ApplicationException {
		traineeDTO.setEmail("abd.ds@dghd.com");
		traineeDTO.setName("Jainish");
		traineeDTO.setPhoneNumber("6584389345");
		
		assertNotNull(registerController.registerUser(traineeDTO));
	}
	
	@Test(expected = ApplicationException.class)
	public void testRegisterUserIfTraineeNameIsEmpty() throws ApplicationException {
		traineeDTO.setEmail("abd.ds@dghd.com");
		traineeDTO.setName("");
		traineeDTO.setPhoneNumber("6584389345");
		
		assertNull(registerController.registerUser(traineeDTO));
	}
	
	@Test(expected = ApplicationException.class)
	public void testRegisterUserIfTraineePhoneNumberIsEmpty() throws ApplicationException {
		traineeDTO.setEmail("abd.ds@dghd.com");
		traineeDTO.setName("Jainish");
		traineeDTO.setPhoneNumber("");
		
		assertNull(registerController.registerUser(traineeDTO));
	}
	
	@Test(expected = ApplicationException.class)
	public void testRegisterUserIfEmailIsEmpty() throws ApplicationException {
		traineeDTO.setEmail("");
		traineeDTO.setName("Jainish");
		traineeDTO.setPhoneNumber("6584389345");
		
		assertNull(registerController.registerUser(traineeDTO));
	}
}
