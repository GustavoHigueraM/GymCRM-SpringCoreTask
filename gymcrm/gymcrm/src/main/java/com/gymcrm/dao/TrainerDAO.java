package com.gymcrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymcrm.model.Trainer;

public interface TrainerDAO extends JpaRepository<Trainer, Long> {

}
