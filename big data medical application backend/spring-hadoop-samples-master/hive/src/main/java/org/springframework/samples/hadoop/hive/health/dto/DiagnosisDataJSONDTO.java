package org.springframework.samples.hadoop.hive.health.dto;


public class DiagnosisDataJSONDTO {
	
	private String personId;
	private String addmissionId;
	private String dcode;
	private String diagnosis;
	
	
	
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
	public String getDcode() {
		return dcode;
	}
	public void setDcode(String dcode) {
		this.dcode = dcode;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	

}
