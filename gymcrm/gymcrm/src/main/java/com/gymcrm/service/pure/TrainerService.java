package com.gymcrm.service.pure;

import java.util.List;

import com.gymcrm.model.Trainer;

public interface TrainerService {

    List<Trainer> getAllTrainers();

    Trainer getTrainerById(Long trainerId);

    void saveTrainer(Trainer trainer);

    void updateTrainer(Long trainerId, Trainer updatedTrainer);

    void deleteTrainer(Long trainerId);
}
