package org.springframework.samples.hadoop.hive.health.Service;

import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;


public interface AddmissionDataService {

	void getAllAddmissionDataRecs();
	
	ResponseDTO saveAddmissionRecord(AddmissionDataJSONDTO addmissionData);
	
}