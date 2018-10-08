package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class LabDataJSONDTO {
	
	private String personId;
	private String addmissionId;
	private String labName;
	private String labValue;
	private String labUnits;
	private String lDate;
	
	
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getAddmissionId() {
		return addmissionId;
	}
	public void setAddmissionId(String addmissionId) {
		this.addmissionId = addmissionId;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public String getLabValue() {
		return labValue;
	}
	public void setLabValue(String labValue) {
		this.labValue = labValue;
	}
	public String getLabUnits() {
		return labUnits;
	}
	public void setLabUnits(String labUnits) {
		this.labUnits = labUnits;
	}
	public String getlDate() {
		return lDate;
	}
	public void setlDate(String lDate) {
		this.lDate = lDate;
	}

	
}
