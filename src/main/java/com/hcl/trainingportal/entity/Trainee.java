package com.hcl.trainingportal.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name = "trainee")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "traineeId")
public class Trainee {
	@Id
	@Column(name = "trainee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long traineeId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email", unique = true)
	private String email;
	
	@OneToMany(mappedBy = "traineeDetails", cascade = CascadeType.ALL)
	private List<Request> traineeRequestList;

}
