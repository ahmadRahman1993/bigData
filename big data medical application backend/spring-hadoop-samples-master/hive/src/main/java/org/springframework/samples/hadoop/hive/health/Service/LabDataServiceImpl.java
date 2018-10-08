package org.springframework.samples.hadoop.hive.health.Service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.hadoop.hive.health.DAO.AddmissionDataRepository;
import org.springframework.samples.hadoop.hive.health.DAO.LabDataRepository;
import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.LabDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("labDataService")
public class LabDataServiceImpl implements LabDataService {
	
	private static final Log log = LogFactory.getLog(LabDataServiceImpl.class);
	
	@Autowired
	private LabDataRepository labDataRepository;
	
	
	
	public List<LabDataDTO> getLabResultsByPatientId(String personId){
		List<LabDataDTO> labData = labDataRepository.getLabResultsByPatientId(personId);
		
		return labData;
	}

	
	@Transactional
	public ResponseDTO saveLabDataRecord(LabDataJSONDTO labData){
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO = labDataRepository.saveLabDataRecord(labData);
		
		return responseDTO;
	}

}
