package com.hcl.trainingportal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name = "trainer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Trainer {

	@Id
	@Column(name = "trainer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainerId;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email", unique = true)
	private String email;
	
	@OneToOne(mappedBy = "trainer", cascade = CascadeType.ALL)
	
	private Course course;
	
	

}
