package org.springframework.samples.hadoop.hive.health.DAO;

import java.util.List;

import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByIdDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByNameDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;


public interface PatientDataRepository {

	List<PatientDataDTO> getLimittedPatientDataRecs();
	
	List<PatientDataByNameDTO> getPatientDataByCriteria(String personName, int personAge, String contactNo);
	
	PatientDataDTO getPatientDataById(String personId);
	
//	List<LabDataDTO> getLabResultsByPatientId(String personId);
	
	ResponseDTO savePatientRecord(PatientDataJSONDTO patientData);
	
	ResponseDTO updatePatientRecord(PatientDataJSONDTO patientData);
}