package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class PatientBodyTempDTO {
	
	private double pTemp;
	private Date vDate;
	
	
	
	public double getpTemp() {
		return pTemp;
	}
	public void setpTemp(double pTemp) {
		this.pTemp = pTemp;
	}
	public Date getvDate() {
		return vDate;
	}
	public void setvDate(Date vDate) {
		this.vDate = vDate;
	}
	
	
}
