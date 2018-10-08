package org.springframework.samples.hadoop.hive.health.Service;

import org.springframework.samples.hadoop.hive.health.dto.DiagnosisDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;


public interface DiagnosisDataService {

	ResponseDTO saveDiagnosisRecord(DiagnosisDataJSONDTO diagnosisData);
	
}