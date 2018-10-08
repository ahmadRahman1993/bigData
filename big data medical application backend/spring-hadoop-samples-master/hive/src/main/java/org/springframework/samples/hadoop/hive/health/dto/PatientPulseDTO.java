package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class PatientPulseDTO {
	
	private double pulse;
	private Date vDate;
	
	
	
	public double getPulse() {
		return pulse;
	}
	public void setPulse(double pulse) {
		this.pulse = pulse;
	}
	public Date getvDate() {
		return vDate;
	}
	public void setvDate(Date vDate) {
		this.vDate = vDate;
	}
	
	
}
