package com.gymcrm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymcrm.dao.TrainerDAO;
import com.gymcrm.model.Trainer;
import com.gymcrm.service.pure.TrainerService;

@Service
public class TrainerServiceImplementation implements TrainerService {

    private final TrainerDAO trainerDAO;

    @Autowired
    public TrainerServiceImplementation(TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerDAO.findAll();
    }

    @Override
    public Trainer getTrainerById(Long trainerId) {
        return trainerDAO.findById(trainerId).orElse(null);
    }

    @Override
    public void saveTrainer(Trainer trainer) {
        trainerDAO.save(trainer);
    }

    @Override
    public void updateTrainer(Long trainerId, Trainer updatedTrainer) {
        Trainer existingTrainer = trainerDAO.findById(trainerId).orElse(null);
        if (existingTrainer != null) {
            existingTrainer.setSpecialization(updatedTrainer.getSpecialization());
            existingTrainer.setUserId(updatedTrainer.getUserId());

            trainerDAO.save(existingTrainer);
        }
    }

    @Override
    public void deleteTrainer(Long trainerId) {
        trainerDAO.deleteById(trainerId);
    }
}
