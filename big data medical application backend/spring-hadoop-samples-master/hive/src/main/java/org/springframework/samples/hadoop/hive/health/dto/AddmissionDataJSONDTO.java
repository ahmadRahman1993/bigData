package org.springframework.samples.hadoop.hive.health.dto;


public class AddmissionDataJSONDTO {
	
	private String personId;
	private String addmissionId;
	private String startDate;
	private String endDate;
	
	
	
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

}
