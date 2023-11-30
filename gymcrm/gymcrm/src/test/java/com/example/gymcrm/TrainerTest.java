package com.example.gymcrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gymcrm.dao.TrainerDAO;
import com.gymcrm.model.Trainer;
import com.gymcrm.service.implementation.TrainerServiceImplementation;

public class TrainerTest {
	 @Mock
	    private TrainerDAO trainerDAO;

	    @InjectMocks
	    private TrainerServiceImplementation trainerService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void saveTrainer_ValidTrainer_SuccessfullySaved() {
	        // Arrange
	        Trainer trainer = new Trainer();
	        trainer.setSpecialization(1L);
	        trainer.setUserId(1L);

	        // Act
	        trainerService.saveTrainer(trainer);

	        // Assert
	        verify(trainerDAO, times(1)).save(trainer);
	    }

	    @Test
	    void updateTrainer_TrainerExists_TrainerUpdated() {
	        // Arrange
	        long trainerId = 1L;
	        Trainer existingTrainer = new Trainer();
	        existingTrainer.setId(trainerId);
	        existingTrainer.setSpecialization(1L);
	        existingTrainer.setUserId(1L);

	        Trainer updatedTrainer = new Trainer();
	        updatedTrainer.setSpecialization(2L);
	        updatedTrainer.setUserId(2L);

	        when(trainerDAO.findById(trainerId)).thenReturn(Optional.of(existingTrainer));

	        // Act
	        trainerService.updateTrainer(trainerId, updatedTrainer);

	        // Assert
	        verify(trainerDAO, times(1)).save(existingTrainer);
	        assertEquals(2L, existingTrainer.getSpecialization());
	        assertEquals(2L, existingTrainer.getUserId());
	    }
}
