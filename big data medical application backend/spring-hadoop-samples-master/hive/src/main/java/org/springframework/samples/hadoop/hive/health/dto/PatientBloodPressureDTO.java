package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class PatientBloodPressureDTO {
	
//	private String personId;
//	private double height;
//	private double weight;
//	private double pulse;
	private double bPresu;
	private double bPresd;
//	private double pTemp;
	private Date vDate;
	
	
	
//	public String getPersonId() {
//		return personId;
//	}
//	public void setPersonId(String personId) {
//		this.personId = personId;
//	}
//	public double getHeight() {
//		return height;
//	}
//	public void setHeight(double height) {
//		this.height = height;
//	}
//	public double getWeight() {
//		return weight;
//	}
//	public void setWeight(double weight) {
//		this.weight = weight;
//	}
//	public double getPulse() {
//		return pulse;
//	}
//	public void setPulse(double pulse) {
//		this.pulse = pulse;
//	}
	public double getbPresu() {
		return bPresu;
	}
	public void setbPresu(double bPresu) {
		this.bPresu = bPresu;
	}
	public double getbPresd() {
		return bPresd;
	}
	public void setbPresd(double bPresd) {
		this.bPresd = bPresd;
	}
//	public double getpTemp() {
//		return pTemp;
//	}
//	public void setpTemp(double pTemp) {
//		this.pTemp = pTemp;
//	}
	public Date getvDate() {
		return vDate;
	}
	public void setvDate(Date vDate) {
		this.vDate = vDate;
	}
	
	
}
