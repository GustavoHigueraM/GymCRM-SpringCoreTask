package com.gymcrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymcrm.model.Training;

public interface TrainingDAO extends JpaRepository<Training,Long> {

}
