package com.gymcrm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymcrm.dao.TrainingDAO;
import com.gymcrm.model.Training;
import com.gymcrm.service.pure.TrainingService;

@Service
public class TrainingServiceImplementation implements TrainingService {

    private final TrainingDAO trainingDAO;

    @Autowired
    public TrainingServiceImplementation(TrainingDAO trainingDAO) {
        this.trainingDAO = trainingDAO;
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingDAO.findAll();
    }

    @Override
    public Training getTrainingById(Long trainingId) {
        return trainingDAO.findById(trainingId).orElse(null);
    }

    @Override
    public void saveTraining(Training training) {
        trainingDAO.save(training);
    }

    @Override
    public void updateTraining(Long trainingId, Training updatedTraining) {
        Training existingTraining = trainingDAO.findById(trainingId).orElse(null);
        if (existingTraining != null) {
            existingTraining.setTraineeId(updatedTraining.getTraineeId());
            existingTraining.setTrainerId(updatedTraining.getTrainerId());
            existingTraining.setTrainingName(updatedTraining.getTrainingName());
            existingTraining.setTrainingTypeId(updatedTraining.getTrainingTypeId());
            existingTraining.setTrainingDate(updatedTraining.getTrainingDate());
            existingTraining.setTrainingDuration(updatedTraining.getTrainingDuration());

            trainingDAO.save(existingTraining);
        }
    }

    @Override
    public void deleteTraining(Long trainingId) {
        trainingDAO.deleteById(trainingId);
    }
}
