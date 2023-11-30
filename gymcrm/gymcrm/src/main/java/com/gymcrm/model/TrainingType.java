package com.gymcrm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="TRAINING_TYPES")
public class TrainingType {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="Training type name is required")
	@Column(name="TRAINING_TYPE_NAME")
	private String trainingTypeName;
	
	//Getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTrainingTypeName() {
		return trainingTypeName;
	}

	public void setTrainingTypeName(String trainingTypeName) {
		this.trainingTypeName = trainingTypeName;
	}

	@Override
	public String toString() {
		return "TrainingType [id=" + id + ", trainingTypeName=" + trainingTypeName + "]";
	}
	
}


