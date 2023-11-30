package com.gymcrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymcrm.model.Trainee;
import com.gymcrm.service.implementation.TraineeServiceImplementation;

@RestController
@RequestMapping("/trainees")
public class TraineeController {

	private final TraineeServiceImplementation traineeServiceImplementation;
	
	@Autowired
	public TraineeController(TraineeServiceImplementation traineeServiceImplementation) {
		this.traineeServiceImplementation = traineeServiceImplementation;
	}
	
	@GetMapping
	public List<Trainee> getAllTrainees(){
		return traineeServiceImplementation.getAllTrainees();
	}
	
	@GetMapping("/{traineeId}")
    public Trainee getTraineeById(@PathVariable Long traineeId) {
        return traineeServiceImplementation.getTraineeById(traineeId);
    }

    @PostMapping
    public void saveTrainee(@RequestBody Trainee trainee) {
        traineeServiceImplementation.saveTrainee(trainee);
    }

    @PutMapping("/{traineeId}")
    public void updateTrainee(@PathVariable Long traineeId, @RequestBody Trainee updatedTrainee) {
        traineeServiceImplementation.updateTrainee(traineeId, updatedTrainee);
    }

    @DeleteMapping("/{traineeId}")
    public void deleteTrainee(@PathVariable Long traineeId) {
        traineeServiceImplementation.deleteTrainee(traineeId);
    }
	
	
}
