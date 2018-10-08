package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class PatientHeightDTO {
	
	private double height;
	private Date vDate;
	
	
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Date getvDate() {
		return vDate;
	}
	public void setvDate(Date vDate) {
		this.vDate = vDate;
	}
	
	
}
