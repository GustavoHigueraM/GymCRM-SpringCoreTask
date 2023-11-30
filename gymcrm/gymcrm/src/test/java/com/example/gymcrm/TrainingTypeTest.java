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

import com.gymcrm.dao.TrainingTypeDAO;
import com.gymcrm.model.TrainingType;
import com.gymcrm.service.implementation.TrainingTypeServiceImplementation;

public class TrainingTypeTest {
	@Mock
    private TrainingTypeDAO trainingTypeDAO;

    @InjectMocks
    private TrainingTypeServiceImplementation trainingTypeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveTrainingType_ValidTrainingType_SuccessfullySaved() {
        // Arrange
        TrainingType trainingType = new TrainingType();
        trainingType.setTrainingTypeName("Strength Training");

        // Act
        trainingTypeService.saveTrainingType(trainingType);

        // Assert
        verify(trainingTypeDAO, times(1)).save(trainingType);
    }

    @Test
    void updateTrainingType_TrainingTypeExists_TrainingTypeUpdated() {
        // Arrange
        long trainingTypeId = 1L;
        TrainingType existingTrainingType = new TrainingType();
        existingTrainingType.setId(trainingTypeId);
        existingTrainingType.setTrainingTypeName("Strength Training");

        TrainingType updatedTrainingType = new TrainingType();
        updatedTrainingType.setTrainingTypeName("Cardio Training");

        when(trainingTypeDAO.findById(trainingTypeId)).thenReturn(Optional.of(existingTrainingType));

        // Act
        trainingTypeService.updateTrainingType(trainingTypeId, updatedTrainingType);

        // Assert
        verify(trainingTypeDAO, times(1)).save(existingTrainingType);
        assertEquals("Cardio Training", existingTrainingType.getTrainingTypeName());
    }
}
