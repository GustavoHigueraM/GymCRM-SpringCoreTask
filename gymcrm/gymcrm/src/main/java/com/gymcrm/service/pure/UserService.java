package com.gymcrm.service.pure;

import java.util.List;

import com.gymcrm.model.User;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long userId);

    void saveUser(User user);

    void updateUser(Long userId, User updatedUser);

    void deleteUser(Long userId);
}
