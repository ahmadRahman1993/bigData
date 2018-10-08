package org.springframework.samples.hadoop.hive.health.Service;

import java.util.List;

import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.LabDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;


public interface LabDataService {
	
	List<LabDataDTO> getLabResultsByPatientId(String personId);

	ResponseDTO saveLabDataRecord(LabDataJSONDTO labData);
	
}