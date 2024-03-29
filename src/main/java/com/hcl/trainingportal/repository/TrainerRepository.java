package com.hcl.trainingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.trainingportal.entity.Trainer;


@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long>  {

}
