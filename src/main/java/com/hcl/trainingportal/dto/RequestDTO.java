package com.hcl.trainingportal.dto;

import java.util.List;

import lombok.Data;

@Data
public class RequestDTO {
	
	private Long courseId;
	
	private String courseName;
	
	private List<SkillDTO> Skills;
	
	private Long traineeId;

}
