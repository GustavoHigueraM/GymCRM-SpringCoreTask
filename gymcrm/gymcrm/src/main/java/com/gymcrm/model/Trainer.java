package com.gymcrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="TRAINERS")
public class Trainer {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name="SPECIALIZATION")
	private long specialization;
	
	@NotNull
	@Column(name="USER_ID")
	private long userId;
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getSpecialization() {
		return specialization;
	}

	public void setSpecialization(long specialization) {
		this.specialization = specialization;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", specialization=" + specialization + ", userId=" + userId + "]";
	}

	
	
}
