package com.gymcrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymcrm.model.TrainingType;

public interface TrainingTypeDAO extends JpaRepository<TrainingType, Long> {

}
