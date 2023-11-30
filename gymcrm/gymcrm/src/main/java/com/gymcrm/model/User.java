package com.gymcrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name="USERS")
public class User {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="First name is required")
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@NotBlank(message="Last name is required")
	@Column(name="LAST_NAME")
	private String lastName;
	
	@NotBlank(message="Username is required")
	@Column(name="USERNAME")
	private String username;
	
	@NotBlank(message="Password is required")
	@Column(name="PASSWORD")
	private String password;
	
	@NotNull(message="Active status is required")
	@Column(name="IS_ACTIVE")
	private boolean isActive;
	
	//Getters and setters
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", isActive=" + isActive + "]";
	}
	
}
