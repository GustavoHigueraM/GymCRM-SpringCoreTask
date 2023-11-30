package com.gymcrm.configuration;

import java.sql.Date;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gymcrm.model.Trainee;
import com.gymcrm.model.Trainer;
import com.gymcrm.model.Training;
import com.gymcrm.model.TrainingType;
import com.gymcrm.model.User;
import com.gymcrm.service.implementation.TraineeServiceImplementation;
import com.gymcrm.service.implementation.TrainerServiceImplementation;
import com.gymcrm.service.implementation.TrainingServiceImplementation;
import com.gymcrm.service.implementation.TrainingTypeServiceImplementation;
import com.gymcrm.service.implementation.UserServiceImplementation;

@Configuration
public class InitDataBean {
	@Bean
	public CommandLineRunner initData(
		UserServiceImplementation userServiceImplementation,
		TrainingTypeServiceImplementation trainingTypeServiceImplementation,
		TraineeServiceImplementation traineeServiceImplementation,
		TrainerServiceImplementation trainerServiceImplementation,
		TrainingServiceImplementation trainingServiceImplementation) {
		return args -> {
            TrainingType trainingType1 = new TrainingType();
            trainingType1.setTrainingTypeName("Easy");
            TrainingType trainingType2 = new TrainingType();
            trainingType2.setTrainingTypeName("Medium");
            TrainingType trainingType3 = new TrainingType();
            trainingType3.setTrainingTypeName("Hard");
            
            trainingTypeServiceImplementation.saveTrainingType(trainingType1);
            trainingTypeServiceImplementation.saveTrainingType(trainingType2);
            trainingTypeServiceImplementation.saveTrainingType(trainingType3);
            
            User user1 = new User();
            user1.setFirstName("Juan");
            user1.setLastName("Perez");
            user1.setIsActive(true);
            userServiceImplementation.saveUser(user1);
            Trainee trainee1 = new Trainee();
            trainee1.setDateOfBirth(new Date(0));
            trainee1.setAddress("Jardines Corregidora");
            trainee1.setUserId(1);
            traineeServiceImplementation.saveTrainee(trainee1);
            
            User user2 = new User();
            user2.setFirstName("Gustavo");
            user2.setLastName("Higuera");
            user2.setIsActive(true);
            userServiceImplementation.saveUser(user2);
            Trainer trainer1 = new Trainer();
            trainer1.setSpecialization(1);
            trainer1.setUserId(2);
            trainerServiceImplementation.saveTrainer(trainer1);
            
            Training training1 = new Training();
            training1.setTraineeId(1);
            training1.setTrainerId(1);
            training1.setTrainingName("Definición");
            training1.setTrainingDuration(25);
            training1.setTrainingTypeId(2);
            training1.setTrainingDate(new Date(0));
            trainingServiceImplementation.saveTraining(training1);
		};
	}


}
