package com.gymcrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymcrm.model.Trainee;

public interface TraineeDAO extends JpaRepository<Trainee, Long>{

}
