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

import com.gymcrm.model.Training;
import com.gymcrm.service.implementation.TrainingServiceImplementation;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

	private final TrainingServiceImplementation trainingServiceImplementation;
	
	@Autowired
	public TrainingController(TrainingServiceImplementation trainingServiceImplementation) {
		this.trainingServiceImplementation = trainingServiceImplementation;
	}
	
	@GetMapping
	public List<Training> getAllTrainings(){
		return trainingServiceImplementation.getAllTrainings();
	}
	
	@GetMapping("/{trainingId}")
    public Training getTrainingById(@PathVariable Long trainingId) {
        return trainingServiceImplementation.getTrainingById(trainingId);
    }

    @PostMapping
    public void saveTraining(@RequestBody Training training) {
        trainingServiceImplementation.saveTraining(training);
    }

    @PutMapping("/{trainingId}")
    public void updateTraining(@PathVariable Long trainingId, @RequestBody Training updatedTraining) {
        trainingServiceImplementation.updateTraining(trainingId, updatedTraining);
    }

    @DeleteMapping("/{trainingId}")
    public void deleteTraining(@PathVariable Long trainingId) {
        trainingServiceImplementation.deleteTraining(trainingId);
    }
	
}
