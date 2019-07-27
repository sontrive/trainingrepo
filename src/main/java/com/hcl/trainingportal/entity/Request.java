package com.hcl.trainingportal.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name = "request")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "requestId")
public class Request {

	@Id
	@Column(name = "request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requestId;

	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private Trainer trainerDetails;

	@ManyToOne
	@JoinColumn(name = "trainee_id")
	private Trainee traineeDetails;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course courseDetails;

	@Column(name = "status")
	private String status;

	@Column(name = "course_start_date")
	private LocalDateTime courseStartDate;

}
