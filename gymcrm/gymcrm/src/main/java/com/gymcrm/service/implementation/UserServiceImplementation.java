package com.gymcrm.service.implementation;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymcrm.dao.UserDAO;
import com.gymcrm.model.User;
import com.gymcrm.service.pure.UserService;

@Service
public class UserServiceImplementation implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImplementation(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return userDAO.findById(userId).orElse(null);
    }

    @Override
    public void saveUser(User user) {
    	//Generate username
    	String generatedUsername = generateUsername(user.getFirstName(), user.getLastName());
    	
    	//Check if the generated username already exists
    	int count = 1;
    	while (userDAO.existsByUsername(generatedUsername)) {
    		generatedUsername= generateUsername(user.getFirstName(), user.getLastName()) + count;
    		count++;
    	}
    	
    	//Generate a random password
    	String generatedPassword = generatePassword();
    	user.setPassword(generatedPassword);
    	
    	user.setUsername(generatedUsername);
    	
        userDAO.save(user);
    }

    @Override
    public void updateUser(Long userId, User updatedUser) {
        User existingUser = userDAO.findById(userId).orElse(null);
        if (existingUser != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setIsActive(updatedUser.isActive());

            userDAO.save(existingUser);
        }
    }

    @Override
    public void deleteUser(Long userId) {
        userDAO.deleteById(userId);
    }
    
    private String generateUsername(String firstName, String lastName) {
    	return firstName + "." + lastName;
    }
    
    private String generatePassword() {
        // Generate a random 10-character password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder passwordBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            passwordBuilder.append(characters.charAt(index));
        }
        return passwordBuilder.toString();
    }
}