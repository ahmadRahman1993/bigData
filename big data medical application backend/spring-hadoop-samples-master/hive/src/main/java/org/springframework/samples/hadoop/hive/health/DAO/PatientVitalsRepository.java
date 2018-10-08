package org.springframework.samples.hadoop.hive.health.DAO;

import java.util.List;

import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.LabDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientBMIDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientBloodPressureDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientBodyTempDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByIdDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByNameDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientHeightDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientPulseDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientVitalsJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientWeightDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;


public interface PatientVitalsRepository {

	List<PatientBloodPressureDTO> getPatientBloodPressureDataById(String personId);
	
	List<PatientBodyTempDTO> getPatientBodyTempDataById(String personId);
	
	List<PatientPulseDTO> getPatientPulseDataById(String personId);
	
	List<PatientHeightDTO> getPatientHeightDataById(String personId);

	List<PatientWeightDTO> getPatientWeightDataById(String personId);
	
	PatientBMIDTO getPatientBMIDataById(String personId);
	
	ResponseDTO savePatientVitalsRecord(PatientVitalsJSONDTO patientVitals);

	
}