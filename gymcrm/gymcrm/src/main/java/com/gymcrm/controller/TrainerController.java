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

import com.gymcrm.model.Trainer;
import com.gymcrm.service.implementation.TrainerServiceImplementation;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
	
	private final TrainerServiceImplementation trainerServiceImplementation;
	
	@Autowired
	public TrainerController(TrainerServiceImplementation trainerServiceImplementation) {
		this.trainerServiceImplementation = trainerServiceImplementation;
	}
	
	@GetMapping
	public List<Trainer> getAllTrainers(){
		return trainerServiceImplementation.getAllTrainers();
	}
	
	@GetMapping("/{trainerId}")
	public Trainer getTrainerById(@PathVariable Long trainerId) {
		return trainerServiceImplementation.getTrainerById(trainerId);
	}
	
	@PostMapping
    public void saveTrainer(@RequestBody Trainer trainer) {
        trainerServiceImplementation.saveTrainer(trainer);
    }

    @PutMapping("/{trainerId}")
    public void updateTrainer(@PathVariable Long trainerId, @RequestBody Trainer updatedTrainer) {
        trainerServiceImplementation.updateTrainer(trainerId, updatedTrainer);
    }

    @DeleteMapping("/{trainerId}")
    public void deleteTrainer(@PathVariable Long trainerId) {
        trainerServiceImplementation.deleteTrainer(trainerId);
    }
}
