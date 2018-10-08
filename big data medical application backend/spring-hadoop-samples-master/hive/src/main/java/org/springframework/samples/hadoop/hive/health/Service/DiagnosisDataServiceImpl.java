package org.springframework.samples.hadoop.hive.health.Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.hadoop.hive.health.DAO.DiagnosisDataRepository;
import org.springframework.samples.hadoop.hive.health.dto.DiagnosisDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("diagnosisDataService")
public class DiagnosisDataServiceImpl implements DiagnosisDataService {
	
	private static final Log log = LogFactory.getLog(DiagnosisDataServiceImpl.class);
	
	@Autowired
	private DiagnosisDataRepository diagnosisDataRepository;
	
	
	
	@Transactional
	public ResponseDTO saveDiagnosisRecord(DiagnosisDataJSONDTO diagnosisData){
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO = diagnosisDataRepository.saveDiagnosisRecord(diagnosisData);
		
		return responseDTO;
	}

}
