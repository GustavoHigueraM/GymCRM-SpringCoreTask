package com.gymcrm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymcrm.dao.TrainingTypeDAO;
import com.gymcrm.model.TrainingType;
import com.gymcrm.service.pure.TrainingTypeService;

@Service
public class TrainingTypeServiceImplementation implements TrainingTypeService {

    private final TrainingTypeDAO trainingTypeDAO;

    @Autowired
    public TrainingTypeServiceImplementation(TrainingTypeDAO trainingTypeDAO) {
        this.trainingTypeDAO = trainingTypeDAO;
    }

    @Override
    public List<TrainingType> getAllTrainingTypes() {
        return trainingTypeDAO.findAll();
    }

    @Override
    public TrainingType getTrainingTypeById(Long trainingTypeId) {
        return trainingTypeDAO.findById(trainingTypeId).orElse(null);
    }

    @Override
    public void saveTrainingType(TrainingType trainingType) {
        trainingTypeDAO.save(trainingType);
    }

    @Override
    public void updateTrainingType(Long trainingTypeId, TrainingType updatedTrainingType) {
        TrainingType existingTrainingType = trainingTypeDAO.findById(trainingTypeId).orElse(null);
        if (existingTrainingType != null) {
            existingTrainingType.setTrainingTypeName(updatedTrainingType.getTrainingTypeName());

            trainingTypeDAO.save(existingTrainingType);
        }
    }

    @Override
    public void deleteTrainingType(Long trainingTypeId) {
        trainingTypeDAO.deleteById(trainingTypeId);
    }
}
