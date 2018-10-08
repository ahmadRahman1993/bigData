package org.springframework.samples.hadoop.hive.health.dto;

import java.util.Date;

public class PatientDataDTO implements Comparable<PatientDataDTO>{
	
	private String personId;
	private String personName;
	private String gender;
	private Date dob;
	private String race;
	private String maritalStatus;
	private String pLanguage;
	private double pPercent;
	private int age;
	private String contact;
	
	private Long createdDate;
	
	
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getpLanguage() {
		return pLanguage;
	}
	public void setpLanguage(String pLanguage) {
		this.pLanguage = pLanguage;
	}
	public double getpPercent() {
		return pPercent;
	}
	public void setpPercent(double pPercent) {
		this.pPercent = pPercent;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public Long getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	//implementing method compareTo;
	@Override
	public int compareTo(PatientDataDTO patientData){
		return this.createdDate.compareTo(patientData.createdDate);
	}


}
