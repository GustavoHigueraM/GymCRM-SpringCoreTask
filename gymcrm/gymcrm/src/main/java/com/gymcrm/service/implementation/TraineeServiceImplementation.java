package com.gymcrm.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymcrm.dao.TraineeDAO;
import com.gymcrm.model.Trainee;
import com.gymcrm.service.pure.TraineeService;

@Service
public class TraineeServiceImplementation implements TraineeService {

    private final TraineeDAO traineeDAO;

    @Autowired
    public TraineeServiceImplementation(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeDAO.findAll();
    }

    @Override
    public Trainee getTraineeById(Long traineeId) {
        return traineeDAO.findById(traineeId).orElse(null);
    }

    @Override
    public void saveTrainee(Trainee trainee) {
        traineeDAO.save(trainee);
    }

    @Override
    public void updateTrainee(Long traineeId, Trainee updatedTrainee) {
        Trainee existingTrainee = traineeDAO.findById(traineeId).orElse(null);
        if (existingTrainee != null) {
            existingTrainee.setDateOfBirth(updatedTrainee.getDateOfBirth());
            existingTrainee.setAddress(updatedTrainee.getAddress());
            existingTrainee.setUserId(updatedTrainee.getUserId());

            traineeDAO.save(existingTrainee);
        }
    }

    @Override
    public void deleteTrainee(Long traineeId) {
        traineeDAO.deleteById(traineeId);
    }
}
