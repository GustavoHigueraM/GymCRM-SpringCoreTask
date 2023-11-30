package com.example.gymcrm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.gymcrm.dao.UserDAO;
import com.gymcrm.model.User;
import com.gymcrm.service.implementation.UserServiceImplementation;

public class UserTest {
	 @Mock
	    private UserDAO userDAO;

	    @InjectMocks
	    private UserServiceImplementation userService;

	    @BeforeEach
	    void setUp() {
	        MockitoAnnotations.openMocks(this);
	    }

	    @Test
	    void saveUser_ValidUser_SuccessfullySaved() {
	        // Arrange
	        User user = new User();
	        user.setFirstName("John");
	        user.setLastName("Doe");

	        when(userDAO.existsByUsername(anyString())).thenReturn(false);

	        // Act
	        userService.saveUser(user);

	        // Assert
	        verify(userDAO, times(1)).save(user);
	        assertNotNull(user.getUsername());
	        assertNotNull(user.getPassword());
	    }

	    @Test
	    void saveUser_GeneratedUsernameAlreadyExists_UsernameWithSuffixGenerated() {
	        // Arrange
	        User user = new User();
	        user.setFirstName("John");
	        user.setLastName("Doe");

	        when(userDAO.existsByUsername(anyString())).thenReturn(true, false);

	        // Act
	        userService.saveUser(user);

	        // Assert
	        verify(userDAO, times(1)).save(user);
	        assertTrue(user.getUsername().startsWith("John.Doe"));
	        assertNotNull(user.getPassword());
	    }

	    @Test
	    void updateUser_UserExists_UserUpdated() {
	        // Arrange
	        long userId = 1L;
	        User existingUser = new User();
	        existingUser.setId(userId);
	        existingUser.setFirstName("John");
	        existingUser.setLastName("Doe");

	        User updatedUser = new User();
	        updatedUser.setFirstName("Jane");
	        updatedUser.setLastName("Smith");

	        when(userDAO.findById(userId)).thenReturn(Optional.of(existingUser));

	        // Act
	        userService.updateUser(userId, updatedUser);

	        // Assert
	        verify(userDAO, times(1)).save(existingUser);
	        assertEquals("Jane", existingUser.getFirstName());
	        assertEquals("Smith", existingUser.getLastName());
	    }
}
