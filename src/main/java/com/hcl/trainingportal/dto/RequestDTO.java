package com.hcl.trainingportal.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
	
	private Long trainerId;
	private Long requestId;
	private String Status;
	private LocalDateTime courseStartDate;
	
}
