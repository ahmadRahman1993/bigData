package org.springframework.samples.hadoop.hive.health.Service;

import java.util.List;

import org.springframework.samples.hadoop.hive.health.dto.PatientDataByNameDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;



public interface PatientDataService {

	List<PatientDataDTO> getLimittedPatientDataRecs();
	
	List<PatientDataByNameDTO> getPatientDataByCriteria(String personName, int personAge, String contactNo);
	
	PatientDataDTO getPatientDataById(String personId);
	
//	List<LabDataDTO> getLabResultsByPatientId(String personId);
	
	ResponseDTO saveOrUpdatePatientRecord(PatientDataJSONDTO patientData);
//	public void getPatientDataByNameTest(String patientName);
	
}