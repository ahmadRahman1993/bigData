package org.springframework.samples.hadoop.hive.health.DAO;

import java.util.List;

import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.LabDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;


public interface LabDataRepository {
	
	List<LabDataDTO> getLabResultsByPatientId(String personId);

	ResponseDTO saveLabDataRecord(LabDataJSONDTO labData);
	
}