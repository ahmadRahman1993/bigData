package org.springframework.samples.hadoop.hive.health.Service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.hadoop.hive.health.DAO.PatientDataRepository;
import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByIdDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByNameDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("patientDataService")
public class PatientDataServiceImpl implements PatientDataService {
	
	private static final Log log = LogFactory.getLog(PatientDataServiceImpl.class);
	
	@Autowired
	private PatientDataRepository patientDataRepository;
	
	
	public List<PatientDataDTO> getLimittedPatientDataRecs(){
		List<PatientDataDTO> patientDataDTOs = patientDataRepository.getLimittedPatientDataRecs();
		
		return patientDataDTOs;
	}
	
	
	public List<PatientDataByNameDTO> getPatientDataByCriteria(String personName, int personAge, String contactNo){
		List<PatientDataByNameDTO> patientDataDTOs = patientDataRepository.getPatientDataByCriteria(personName, personAge, contactNo);
		
		return patientDataDTOs;
	}
	
	
	public PatientDataDTO getPatientDataById(String personId){
		PatientDataDTO patientData = patientDataRepository.getPatientDataById(personId);
		
		return patientData;
	}
	
	
//	public List<LabDataDTO> getLabResultsByPatientId(String personId){
//		List<LabDataDTO> labData = patientDataRepository.getLabResultsByPatientId(personId);
//		
//		return labData;
//	}
	
	
	@Transactional
	public ResponseDTO saveOrUpdatePatientRecord(PatientDataJSONDTO patientData){
		ResponseDTO responseDTO = new ResponseDTO();
		
		if(patientData.getPersonId().equals("0")){
			responseDTO = patientDataRepository.savePatientRecord(patientData);	
		}else if(!patientData.getPersonId().equals("0") && !patientData.getPersonId().isEmpty()){
			responseDTO = patientDataRepository.updatePatientRecord(patientData);
		}
		
		return responseDTO;
	}
	
	
	
	
	
	
	
//	public void getPatientDataByNameTest(String patientName){
//		List<PatientDataDTO> patientDataDTOs = patientDataRepository.getPatientDataByName(patientName);
//		
//		for (PatientDataDTO patientDataDTO : patientDataDTOs) {
//			System.out.println(patientDataDTO.getPersonId() + "\t" + patientDataDTO.getPersonName() + "\t" + patientDataDTO.getGender() + "\t" + patientDataDTO.getDob() +"\t" + patientDataDTO.getAge());
//		}
//	}

	
}
