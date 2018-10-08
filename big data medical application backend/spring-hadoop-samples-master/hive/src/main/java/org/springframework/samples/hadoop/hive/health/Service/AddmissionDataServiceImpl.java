package org.springframework.samples.hadoop.hive.health.Service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.hadoop.hive.health.DAO.AddmissionDataRepository;
import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("addmissionDataService")
public class AddmissionDataServiceImpl implements AddmissionDataService {
	
	private static final Log log = LogFactory.getLog(AddmissionDataServiceImpl.class);
	
	@Autowired
	private AddmissionDataRepository addmissionDataRepository;
	
	
	public void getAllAddmissionDataRecs(){
		List<AddmissionDataDTO> addmissionDataDTOs = addmissionDataRepository.getAllAddmissionDataRecs();
		
		for (AddmissionDataDTO addmissionDataDTO : addmissionDataDTOs) {
			System.out.println(addmissionDataDTO.getPersonId() + "\t" + addmissionDataDTO.getAddmissionId() + "\t" + addmissionDataDTO.getStartDate() + "\t" + addmissionDataDTO.getEndDate());
		}
	}
	
	
	@Transactional
	public ResponseDTO saveAddmissionRecord(AddmissionDataJSONDTO addmissionData){
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO = addmissionDataRepository.saveAddmissionRecord(addmissionData);
		
		return responseDTO;
	}

}
