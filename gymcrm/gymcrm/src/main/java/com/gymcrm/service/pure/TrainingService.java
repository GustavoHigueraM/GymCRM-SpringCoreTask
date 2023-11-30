package com.gymcrm.service.pure;

import java.util.List;

import com.gymcrm.model.Training;

public interface TrainingService {

    List<Training> getAllTrainings();

    Training getTrainingById(Long trainingId);

    void saveTraining(Training training);

    void updateTraining(Long trainingId, Training updatedTraining);

    void deleteTraining(Long trainingId);
}
