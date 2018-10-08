package org.springframework.samples.hadoop.hive.health.DAO;

import org.springframework.samples.hadoop.hive.health.dto.DiagnosisDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;


public interface DiagnosisDataRepository {

	ResponseDTO saveDiagnosisRecord(DiagnosisDataJSONDTO diagnosisData);
	
}