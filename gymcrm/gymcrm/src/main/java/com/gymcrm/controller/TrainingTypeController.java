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

import com.gymcrm.model.TrainingType;
import com.gymcrm.service.implementation.TrainingTypeServiceImplementation;

@RestController
@RequestMapping("/trainingTypes")
public class TrainingTypeController {
	
	private final TrainingTypeServiceImplementation trainingTypeServiceImplementation;
	
	@Autowired
	public TrainingTypeController(TrainingTypeServiceImplementation trainingTypeServiceImplementation) {
		this.trainingTypeServiceImplementation = trainingTypeServiceImplementation;
	}
	
	@GetMapping
	public List<TrainingType> getAllTrainingTypes(){
		return trainingTypeServiceImplementation.getAllTrainingTypes();
	}
	
	@GetMapping("/{trainingTypeId}")
    public TrainingType getTrainingTypeById(@PathVariable Long trainingTypeId) {
        return trainingTypeServiceImplementation.getTrainingTypeById(trainingTypeId);
    }

    @PostMapping
    public void saveTrainingType(@RequestBody TrainingType trainingType) {
        trainingTypeServiceImplementation.saveTrainingType(trainingType);
    }

    @PutMapping("/{trainingTypeId}")
    public void updateTrainingType(@PathVariable Long trainingTypeId, @RequestBody TrainingType updatedTrainingType) {
        trainingTypeServiceImplementation.updateTrainingType(trainingTypeId, updatedTrainingType);
    }

    @DeleteMapping("/{trainingTypeId}")
    public void deleteTrainingType(@PathVariable Long trainingTypeId) {
        trainingTypeServiceImplementation.deleteTrainingType(trainingTypeId);
    }
}
