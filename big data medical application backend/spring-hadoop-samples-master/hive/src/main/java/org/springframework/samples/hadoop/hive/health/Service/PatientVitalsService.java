package org.springframework.samples.hadoop.hive.health.Service;

import org.springframework.samples.hadoop.hive.health.dto.PatientBMIDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientVitalsJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarDataComparableVO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarDataVO;



public interface PatientVitalsService {
	
	SingleBarDataComparableVO getPatientBloodPressureDataById(String personId);
	
	SingleBarDataVO getPatientBodyTempDataById(String personId);
	
//	SingleBarDataVO getPatientPulseDataById(String personId);
	SingleBarDataComparableVO getPatientPulseDataById(String personId);
	
	SingleBarDataVO getPatientHeightDataById(String personId);

//	SingleBarDataVO getPatientWeightDataById(String personId);
	SingleBarDataComparableVO getPatientWeightDataById(String personId);
	
	PatientBMIDTO getPatientBMIDataById(String personId);
	
	ResponseDTO savePatientVitalsRecord(PatientVitalsJSONDTO patientVitals);
	
}