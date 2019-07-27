package com.hcl.trainingportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.trainingportal.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
	
	@Query(value= "select * from request where trainer_id= :trainerId and status='PENDING'", nativeQuery=true)
	public Optional<Request> findPendingRequests(Long trainerId);

}
