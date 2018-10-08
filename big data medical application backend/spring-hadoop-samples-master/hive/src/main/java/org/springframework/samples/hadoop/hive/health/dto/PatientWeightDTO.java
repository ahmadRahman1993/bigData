package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class PatientWeightDTO {
	
	private double weight;
	private Date vDate;
	
	
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getvDate() {
		return vDate;
	}
	public void setvDate(Date vDate) {
		this.vDate = vDate;
	}
	
	
}
