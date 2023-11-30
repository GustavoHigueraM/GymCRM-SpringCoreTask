package com.example.gymcrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gymcrm.dao.TrainingDAO;
import com.gymcrm.model.Training;
import com.gymcrm.service.implementation.TrainingServiceImplementation;

public class TrainingTest {
	@Mock
    private TrainingDAO trainingDAO;

    @InjectMocks
    private TrainingServiceImplementation trainingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveTraining_ValidTraining_SuccessfullySaved() {
        // Arrange
        Training training = new Training();
        training.setTraineeId(1L);
        training.setTrainerId(1L);
        training.setTrainingName("Example Training");
        training.setTrainingTypeId(1L);
        training.setTrainingDate(new Date(System.currentTimeMillis()));
        training.setTrainingDuration(60);

        // Act
        trainingService.saveTraining(training);

        // Assert
        verify(trainingDAO, times(1)).save(training);
    }

    @Test
    void updateTraining_TrainingExists_TrainingUpdated() {
        // Arrange
        long trainingId = 1L;
        Training existingTraining = new Training();
        existingTraining.setId(trainingId);
        existingTraining.setTraineeId(1L);
        existingTraining.setTrainerId(1L);
        existingTraining.setTrainingName("Example Training");
        existingTraining.setTrainingTypeId(1L);
        existingTraining.setTrainingDate(new Date(System.currentTimeMillis()));
        existingTraining.setTrainingDuration(60);

        Training updatedTraining = new Training();
        updatedTraining.setTraineeId(2L);
        updatedTraining.setTrainerId(2L);
        updatedTraining.setTrainingName("Updated Training");
        updatedTraining.setTrainingTypeId(2L);
        updatedTraining.setTrainingDate(new Date(System.currentTimeMillis()));
        updatedTraining.setTrainingDuration(90);

        when(trainingDAO.findById(trainingId)).thenReturn(Optional.of(existingTraining));

        // Act
        trainingService.updateTraining(trainingId, updatedTraining);

        // Assert
        verify(trainingDAO, times(1)).save(existingTraining);
        assertEquals(2L, existingTraining.getTraineeId());
        assertEquals(2L, existingTraining.getTrainerId());
        assertEquals("Updated Training", existingTraining.getTrainingName());
        assertEquals(2L, existingTraining.getTrainingTypeId());
        assertEquals(90, existingTraining.getTrainingDuration());
    }
}
