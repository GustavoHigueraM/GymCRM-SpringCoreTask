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

import com.gymcrm.dao.TraineeDAO;
import com.gymcrm.model.Trainee;
import com.gymcrm.service.implementation.TraineeServiceImplementation;

public class TraineeTest {
	 @Mock
	    private TraineeDAO traineeDAO;

	    @InjectMocks
	    private TraineeServiceImplementation traineeService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void saveTrainee_ValidTrainee_SuccessfullySaved() {
	        // Arrange
	        Trainee trainee = new Trainee();
	        trainee.setDateOfBirth(Date.valueOf("1990-01-01"));
	        trainee.setAddress("123 Main St");
	        trainee.setUserId(1L);

	        // Act
	        traineeService.saveTrainee(trainee);

	        // Assert
	        verify(traineeDAO, times(1)).save(trainee);
	    }

	    @Test
	    void updateTrainee_TraineeExists_TraineeUpdated() {
	        // Arrange
	        long traineeId = 1L;
	        Trainee existingTrainee = new Trainee();
	        existingTrainee.setId(traineeId);
	        existingTrainee.setDateOfBirth(Date.valueOf("1990-01-01"));
	        existingTrainee.setAddress("123 Main St");
	        existingTrainee.setUserId(1L);

	        Trainee updatedTrainee = new Trainee();
	        updatedTrainee.setDateOfBirth(Date.valueOf("1995-01-01"));
	        updatedTrainee.setAddress("456 Oak St");
	        updatedTrainee.setUserId(2L);

	        when(traineeDAO.findById(traineeId)).thenReturn(Optional.of(existingTrainee));

	        // Act
	        traineeService.updateTrainee(traineeId, updatedTrainee);

	        // Assert
	        verify(traineeDAO, times(1)).save(existingTrainee);
	        assertEquals(Date.valueOf("1995-01-01"), existingTrainee.getDateOfBirth());
	        assertEquals("456 Oak St", existingTrainee.getAddress());
	        assertEquals(2L, existingTrainee.getUserId());
	    }
}
