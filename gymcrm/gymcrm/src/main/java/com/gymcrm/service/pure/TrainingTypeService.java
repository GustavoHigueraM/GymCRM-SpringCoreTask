package com.gymcrm.service.pure;

import java.util.List;

import com.gymcrm.model.TrainingType;

public interface TrainingTypeService {

    List<TrainingType> getAllTrainingTypes();

    TrainingType getTrainingTypeById(Long trainingTypeId);

    void saveTrainingType(TrainingType trainingType);

    void updateTrainingType(Long trainingTypeId, TrainingType updatedTrainingType);

    void deleteTrainingType(Long trainingTypeId);
}
