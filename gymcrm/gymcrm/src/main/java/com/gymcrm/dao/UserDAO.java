package com.gymcrm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymcrm.model.User;

public interface UserDAO extends JpaRepository<User, Long> {
	boolean existsByUsername(String username);
}
