package org.springframework.samples.hadoop.hive.health.DAO;

import java.util.List;

import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;


public interface AddmissionDataRepository {

	List<AddmissionDataDTO> getAllAddmissionDataRecs();
	
	ResponseDTO saveAddmissionRecord(AddmissionDataJSONDTO addmissionData);
	
}