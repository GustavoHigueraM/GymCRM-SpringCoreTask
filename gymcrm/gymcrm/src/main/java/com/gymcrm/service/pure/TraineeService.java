package com.gymcrm.service.pure;

import java.util.List;

import com.gymcrm.model.Trainee;

public interface TraineeService {

    List<Trainee> getAllTrainees();

    Trainee getTraineeById(Long traineeId);

    void saveTrainee(Trainee trainee);

    void updateTrainee(Long traineeId, Trainee updatedTrainee);

    void deleteTrainee(Long traineeId);
}