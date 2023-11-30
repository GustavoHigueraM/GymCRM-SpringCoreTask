package com.gymcrm.model;

import java.sql.Date;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="TRAININGS")
public class Training {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name="TRAINEE_ID")
	private long traineeId;
	
	@NotNull
	@Column(name="TRAINER_ID")
	private long trainerId;
	
	@NotNull
	@Column(name="TRAINING_NAME")
	private String trainingName;
	
	@NotNull
	@Column(name="TRAINING_TYPE_ID")
	private long trainingTypeId;
	
	@NotNull
	@Column(name="TRAINING_DATE")
	private Date trainingDate;
	
	@NotNull
	@Column(name="TRAINING_DURATION")
	private int trainingDuration;

	//Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public long getTrainingTypeId() {
		return trainingTypeId;
	}

	public void setTrainingTypeId(long trainingTypeId) {
		this.trainingTypeId = trainingTypeId;
	}

	public Date getTrainingDate() {
		return trainingDate;
	}

	public void setTrainingDate(Date trainingDate) {
		this.trainingDate = trainingDate;
	}

	public int getTrainingDuration() {
		return trainingDuration;
	}

	public void setTrainingDuration(int trainingDuration) {
		this.trainingDuration = trainingDuration;
	}

	@Override
	public String toString() {
		return "Training [id=" + id + ", traineeId=" + traineeId + ", trainerId=" + trainerId + ", trainingName="
				+ trainingName + ", trainingTypeId=" + trainingTypeId + ", trainingDate=" + trainingDate
				+ ", trainingDuration=" + trainingDuration + "]";
	}
	
}
