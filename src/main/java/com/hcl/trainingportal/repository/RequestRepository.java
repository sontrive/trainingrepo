package com.hcl.trainingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RequestRepository extends JpaRepository<Repository, Long>  {

}
