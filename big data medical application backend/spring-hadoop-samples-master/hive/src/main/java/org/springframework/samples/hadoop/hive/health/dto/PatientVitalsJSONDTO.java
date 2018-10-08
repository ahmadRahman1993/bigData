package org.springframework.samples.hadoop.hive.health.dto;


public class PatientVitalsJSONDTO {
	
	private String personId;
	private String height;
	private String weight;
	private String pulse;
	private String bpresu;
	private String bpresd;
	private String btemp;
	private String vdate;
	
	
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getPulse() {
		return pulse;
	}
	public void setPulse(String pulse) {
		this.pulse = pulse;
	}
	public String getBpresu() {
		return bpresu;
	}
	public void setBpresu(String bpresu) {
		this.bpresu = bpresu;
	}
	public String getBpresd() {
		return bpresd;
	}
	public void setBpresd(String bpresd) {
		this.bpresd = bpresd;
	}
	public String getBtemp() {
		return btemp;
	}
	public void setBtemp(String btemp) {
		this.btemp = btemp;
	}
	public String getVdate() {
		return vdate;
	}
	public void setVdate(String vdate) {
		this.vdate = vdate;
	}
	

}
