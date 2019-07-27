package com.hcl.trainingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trainingportal.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

}
