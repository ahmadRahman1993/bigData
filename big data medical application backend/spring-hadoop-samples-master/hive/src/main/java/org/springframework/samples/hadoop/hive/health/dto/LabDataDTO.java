package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class LabDataDTO {
	
	private String labName;
	private double labValue;
	private String labUnits;
	private Date lDate;
	
	
	
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public double getLabValue() {
		return labValue;
	}
	public void setLabValue(double labValue) {
		this.labValue = labValue;
	}
	public String getLabUnits() {
		return labUnits;
	}
	public void setLabUnits(String labUnits) {
		this.labUnits = labUnits;
	}
	public Date getlDate() {
		return lDate;
	}
	public void setlDate(Date lDate) {
		this.lDate = lDate;
	}

	
}
