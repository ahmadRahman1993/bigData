package org.springframework.samples.hadoop.hive.health.Service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.hadoop.hive.health.DAO.PatientVitalsRepository;
import org.springframework.samples.hadoop.hive.health.dto.ETDConverter;
import org.springframework.samples.hadoop.hive.health.dto.PatientBMIDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientBloodPressureDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientBodyTempDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientHeightDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientPulseDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientVitalsJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientWeightDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarDataComparableVO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarDataVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("patientVitalsService")
public class PatientVitalsServiceImpl implements PatientVitalsService {
	
	private static final Log log = LogFactory.getLog(PatientVitalsServiceImpl.class);
	
	@Autowired
	private PatientVitalsRepository patientVitalsRepository;
	
	
	
	public SingleBarDataComparableVO getPatientBloodPressureDataById(String personId){
		List<PatientBloodPressureDTO> patientBloodPressureData = patientVitalsRepository.getPatientBloodPressureDataById(personId);
		
		SingleBarDataComparableVO singleBarDataVO = ETDConverter.convertPatientBloodPressureDataForSingleBar(patientBloodPressureData);
		
		return singleBarDataVO;
	}
	
	
	public SingleBarDataVO getPatientBodyTempDataById(String personId){
		List<PatientBodyTempDTO> patientBodyTempData = patientVitalsRepository.getPatientBodyTempDataById(personId);
		
		SingleBarDataVO singleBarDataVO = ETDConverter.convertPatientBodyTempDataForSingleBar(patientBodyTempData);
		
		return singleBarDataVO;
		
	}
	
	
	public SingleBarDataComparableVO getPatientPulseDataById(String personId){
		List<PatientPulseDTO> patientPulseData = patientVitalsRepository.getPatientPulseDataById(personId);
		
		SingleBarDataComparableVO singleBarDataVO = ETDConverter.convertPatientPulseDataForSingleBar(patientPulseData);
		
		return singleBarDataVO;
	}

	
	public SingleBarDataVO getPatientHeightDataById(String personId){
		List<PatientHeightDTO> patientHeightData = patientVitalsRepository.getPatientHeightDataById(personId);
		
		SingleBarDataVO singleBarDataVO = ETDConverter.convertPatientHeightDataForSingleBar(patientHeightData);
		
		return singleBarDataVO;
	}
	
	
	public SingleBarDataComparableVO getPatientWeightDataById(String personId){
		List<PatientWeightDTO> patientWeightData = patientVitalsRepository.getPatientWeightDataById(personId);
		
		SingleBarDataComparableVO singleBarDataVO = ETDConverter.convertPatientWeightDataForSingleBar(patientWeightData);
		
		return singleBarDataVO;
	}
	
	
	
	public PatientBMIDTO getPatientBMIDataById(String personId){
		PatientBMIDTO patientBMIData = patientVitalsRepository.getPatientBMIDataById(personId);
				
		return patientBMIData;
	}
	
	
	@Transactional
	public ResponseDTO savePatientVitalsRecord(PatientVitalsJSONDTO patientVitals){
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO = patientVitalsRepository.savePatientVitalsRecord(patientVitals);
		
		return responseDTO;
	}

	
}
