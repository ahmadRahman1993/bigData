package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class AddmissionDataDTO {
	
	private String personId;
	private int addmissionId;
	private Date startDate;
	private Date endDate;
	
	
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public int getAddmissionId() {
		return addmissionId;
	}
	public void setAddmissionId(int addmissionId) {
		this.addmissionId = addmissionId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	

}
