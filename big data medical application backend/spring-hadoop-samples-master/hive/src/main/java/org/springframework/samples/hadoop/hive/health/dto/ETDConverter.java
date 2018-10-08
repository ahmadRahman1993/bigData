package org.springframework.samples.hadoop.hive.health.dto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.samples.hadoop.hive.health.utils.DateUtils;
import org.springframework.samples.hadoop.hive.health.utils.DatesComparator;
import org.springframework.samples.hadoop.hive.health.utils.MathsUtils;
import org.springframework.samples.hadoop.hive.health.utils.PatientDataComparator;

public class ETDConverter {
	
	private static final Log log = LogFactory.getLog(ETDConverter.class);
	
	public static List<AddmissionDataDTO> getAllAddmissionDataRecs(ResultSet res){
		List<AddmissionDataDTO> addmissionDataDTOs = new ArrayList<AddmissionDataDTO>();
		
		try{
			while (res.next()) {
				AddmissionDataDTO addmissionDataDTO = new AddmissionDataDTO();
				addmissionDataDTO.setPersonId(res.getString(1));
				addmissionDataDTO.setAddmissionId(res.getInt(2));
				addmissionDataDTO.setStartDate(res.getDate(3));
				addmissionDataDTO.setEndDate(res.getDate(4));
				
				addmissionDataDTOs.add(addmissionDataDTO);
			}
		}catch(Exception e){
			
		}
		
		return addmissionDataDTOs;
	}

	
	public static List<PatientDataDTO> convertPatientDataRecs(ResultSet res){
		List<PatientDataDTO> patientDataDTOs = new ArrayList<PatientDataDTO>();
		
		try{
			while (res.next()) {
				PatientDataDTO patientDataDTO = new PatientDataDTO();
				patientDataDTO.setPersonId(res.getString(1));
				patientDataDTO.setPersonName(res.getString(2));
				patientDataDTO.setGender(res.getString(3));
				patientDataDTO.setDob(res.getDate(4));
				patientDataDTO.setRace(res.getString(5));
				patientDataDTO.setMaritalStatus(res.getString(6));
				patientDataDTO.setpLanguage(res.getString(7));
				patientDataDTO.setpPercent(res.getDouble(8));
				patientDataDTO.setAge(res.getInt(9));
				patientDataDTO.setContact(res.getString(10));
				patientDataDTO.setCreatedDate(res.getLong(11));
				
				patientDataDTOs.add(patientDataDTO);
			}
		}catch(Exception e){
			
		}
		
		//Sorting Arraylist below;
		Collections.sort(patientDataDTOs, new PatientDataComparator());

		List<PatientDataDTO> limittedPatientDataDTOs = patientDataDTOs.subList(0, 5);
		
		return limittedPatientDataDTOs;
	}
	
	
	public static List<PatientDataByNameDTO> getPatientDataByCriteria(ResultSet res){
		List<PatientDataByNameDTO> patientDataDTOs = new ArrayList<PatientDataByNameDTO>();
		
		try{
			while (res.next()) {
				PatientDataByNameDTO patientDataDTO = new PatientDataByNameDTO();
				patientDataDTO.setPersonId(res.getString(1));
				patientDataDTO.setPersonName(res.getString(2));
				patientDataDTO.setGender(res.getString(3));
				patientDataDTO.setDob(res.getDate(4));
				patientDataDTO.setAge(res.getInt(5));
				patientDataDTO.setContact(res.getString(6));
				
				patientDataDTOs.add(patientDataDTO);
			}
		}catch(Exception e){
			
		}
		
		return patientDataDTOs;
	}

	
	
	public static PatientDataDTO convertPatientDataById(ResultSet res){
		PatientDataDTO patientDataDTO = new PatientDataDTO();
		
		try{
			while (res.next()) {
				patientDataDTO.setPersonId(res.getString(1));
				patientDataDTO.setPersonName(res.getString(2));
				patientDataDTO.setGender(res.getString(3));
				patientDataDTO.setDob(res.getDate(4));
				patientDataDTO.setRace(res.getString(5));
				patientDataDTO.setMaritalStatus(res.getString(6));
				patientDataDTO.setpLanguage(res.getString(7));
				patientDataDTO.setpPercent(res.getDouble(8));
				patientDataDTO.setAge(res.getInt(9));
				patientDataDTO.setContact(res.getString(10));
				patientDataDTO.setCreatedDate(res.getLong(11));
			}
		}catch(Exception e){
			
		}
		
		return patientDataDTO;
	}


	public static List<LabDataDTO> getLabResultsByPatientId(ResultSet res){
		List<LabDataDTO> labDataDTOs = new ArrayList<LabDataDTO>();
		
		try{
			while (res.next()) {
				LabDataDTO labDataDTO = new LabDataDTO();
				labDataDTO.setLabName(res.getString(1));
				labDataDTO.setLabValue(res.getDouble(2));
				labDataDTO.setLabUnits(res.getString(3));
				labDataDTO.setlDate(res.getDate(4));
				
				labDataDTOs.add(labDataDTO);
			}
		}catch(Exception e){
			
		}
		
		return labDataDTOs;
	}

	
	
	public static List<PatientBloodPressureDTO> getPatientBloodPressureDataById(ResultSet res){
		List<PatientBloodPressureDTO> patientBloodPressureDTOs = new ArrayList<PatientBloodPressureDTO>();
		
		try{
			while (res.next()) {
				PatientBloodPressureDTO patientBloodPressureData = new PatientBloodPressureDTO();
				patientBloodPressureData.setvDate(res.getDate(1));
				patientBloodPressureData.setbPresu(res.getDouble(2));
				patientBloodPressureData.setbPresd(res.getDouble(3));
				
				patientBloodPressureDTOs.add(patientBloodPressureData);
			}
		}catch(Exception e){
			
		}
		
		return patientBloodPressureDTOs;
	}

	
	
	public static List<PatientBodyTempDTO> convertPatientBodyTempData(ResultSet res){
		List<PatientBodyTempDTO> patientBodyTempDTOs = new ArrayList<PatientBodyTempDTO>();
		
		try{
			while (res.next()) {
				PatientBodyTempDTO patientBodyTempData = new PatientBodyTempDTO();
				patientBodyTempData.setvDate(res.getDate(1));
				patientBodyTempData.setpTemp(res.getDouble(2));
				
				patientBodyTempDTOs.add(patientBodyTempData);
			}
		}catch(Exception e){
			
		}
		
		return patientBodyTempDTOs;
	}

	
	
	public static List<PatientPulseDTO> convertPatientPulseData(ResultSet res){
		List<PatientPulseDTO> patientPulseDTOs = new ArrayList<PatientPulseDTO>();
		
		try{
			while (res.next()) {
				PatientPulseDTO patientPulseData = new PatientPulseDTO();
				patientPulseData.setvDate(res.getDate(1));
				patientPulseData.setPulse(res.getDouble(2));
				
				patientPulseDTOs.add(patientPulseData);
			}
		}catch(Exception e){
			
		}
		
		return patientPulseDTOs;
	}
	
	
	
	public static List<PatientHeightDTO> convertPatientHeightData(ResultSet res){
		List<PatientHeightDTO> patientHeightDTOs = new ArrayList<PatientHeightDTO>();
		
		try{
			while (res.next()) {
				PatientHeightDTO patientHeightData = new PatientHeightDTO();
				patientHeightData.setvDate(res.getDate(1));
				patientHeightData.setHeight(res.getDouble(2));
				
				patientHeightDTOs.add(patientHeightData);
			}
		}catch(Exception e){
			
		}
		
		return patientHeightDTOs;
	}
	
	
	
	public static List<PatientWeightDTO> convertPatientWeightData(ResultSet res){
		List<PatientWeightDTO> patientWeightDTOs = new ArrayList<PatientWeightDTO>();
		
		try{
			while (res.next()) {
				PatientWeightDTO patientWeightData = new PatientWeightDTO();
				patientWeightData.setvDate(res.getDate(1));
				patientWeightData.setWeight(res.getDouble(2));
				
				patientWeightDTOs.add(patientWeightData);
			}
		}catch(Exception e){
			
		}
		
		return patientWeightDTOs;
	}
	
	
	public static SingleBarDataComparableVO convertPatientBloodPressureDataForSingleBar(List<PatientBloodPressureDTO> patientBloodPressureData){
		SingleBarDataComparableVO singleBarDataVO = new SingleBarDataComparableVO();
		List<SingleBarDataMainComparableVO> singleBarDataMainVOs = new ArrayList<SingleBarDataMainComparableVO>();
//		VO below will be commented out totally;
//		List<SingleBarValuesVO> singleBarValuesVOs = new ArrayList<SingleBarValuesVO>();
		
//		New VO's for Blood Pressure Systolic and Diastolic readings;
		List<SingleBarValuesComparableVO> singleBarSystolicValuesVOs = new ArrayList<SingleBarValuesComparableVO>();
		List<SingleBarValuesComparableVO> singleBarDiastolicValuesVOs = new ArrayList<SingleBarValuesComparableVO>();
		
//		SingleBarDataMainVO singleBarDataMainVO = new SingleBarDataMainVO();
		
		
		for(int i=0; i<2; i++){
			SingleBarDataMainComparableVO singleBarDataMainVO1 = new SingleBarDataMainComparableVO();
			
			if(i==0){
				singleBarDataMainVO1.setKey("Systolic");
			}else if(i==1){
				singleBarDataMainVO1.setKey("Diastolic");
			}
			
			//for loop below;
			for (int j = 0; j<patientBloodPressureData.size(); j++) {
				PatientBloodPressureDTO patientBloodPressureObj =  patientBloodPressureData.get(j);
				
				if(i==0){
//					work below for 'Systolic' readings;
					SingleBarValuesComparableVO singleBarSystolicValuesVO = new SingleBarValuesComparableVO();
					singleBarSystolicValuesVO.setX(DateUtils.convertDateFormat(patientBloodPressureObj.getvDate().toString()));
					singleBarSystolicValuesVO.setY(patientBloodPressureObj.getbPresu());
					singleBarSystolicValuesVOs.add(singleBarSystolicValuesVO);
					//Sorting 'Systolic' Arraylist below;
					Collections.sort(singleBarSystolicValuesVOs, new DatesComparator());
					singleBarDataMainVO1.setValues(singleBarSystolicValuesVOs);
				}else if(i==1){
//					work below for 'Diastolic' readings;
					SingleBarValuesComparableVO singleBarDiastolicValuesVO = new SingleBarValuesComparableVO();
					singleBarDiastolicValuesVO.setX(DateUtils.convertDateFormat(patientBloodPressureObj.getvDate().toString()));
					singleBarDiastolicValuesVO.setY(patientBloodPressureObj.getbPresd());
					singleBarDiastolicValuesVOs.add(singleBarDiastolicValuesVO);
					//Sorting 'Diastolic' Arraylist below;
					Collections.sort(singleBarDiastolicValuesVOs, new DatesComparator());
					singleBarDataMainVO1.setValues(singleBarDiastolicValuesVOs);
				}
			}

			singleBarDataMainVOs.add(singleBarDataMainVO1);
			singleBarDataVO.setSingleBarData(singleBarDataMainVOs);
		}
		
		return singleBarDataVO;
	}

	
	public static SingleBarDataVO convertPatientBodyTempDataForSingleBar(List<PatientBodyTempDTO> patientBodyTempData){
		SingleBarDataVO singleBarDataVO = new SingleBarDataVO();
		List<SingleBarDataMainVO> singleBarDataMainVOs = new ArrayList<SingleBarDataMainVO>();
		List<SingleBarValuesVO> singleBarValuesVOs = new ArrayList<SingleBarValuesVO>();
		SingleBarDataMainVO singleBarDataMainVO = new SingleBarDataMainVO();
		
		singleBarDataMainVO.setKey("Body Temperature");
		singleBarDataMainVO.setColor("#ff9900");
		
		for (int i = 0; i<patientBodyTempData.size(); i++) {
			PatientBodyTempDTO patientBodyTempObj =  patientBodyTempData.get(i);
			SingleBarValuesVO singleBarValuesVO = new SingleBarValuesVO();
			
			singleBarValuesVO.setX(DateUtils.convertDateFormat(patientBodyTempObj.getvDate().toString()));
			singleBarValuesVO.setY(patientBodyTempObj.getpTemp());
			
			singleBarValuesVOs.add(singleBarValuesVO);
		}
		
		singleBarDataMainVO.setValues(singleBarValuesVOs);
		singleBarDataMainVOs.add(singleBarDataMainVO);
		singleBarDataVO.setSingleBarData(singleBarDataMainVOs);
		
		return singleBarDataVO;
	}
	
	
	public static SingleBarDataComparableVO convertPatientPulseDataForSingleBar(List<PatientPulseDTO> patientPulseData){
		SingleBarDataComparableVO singleBarDataVO = new SingleBarDataComparableVO();
		List<SingleBarDataMainComparableVO> singleBarDataMainVOs = new ArrayList<SingleBarDataMainComparableVO>();
		List<SingleBarValuesComparableVO> singleBarValuesVOs = new ArrayList<SingleBarValuesComparableVO>();
		SingleBarDataMainComparableVO singleBarDataMainVO = new SingleBarDataMainComparableVO();
		
		singleBarDataMainVO.setKey("Pulse");
		singleBarDataMainVO.setColor("#8CC152");
		
		for (int i = 0; i<patientPulseData.size(); i++) {
			PatientPulseDTO patientPulseObj =  patientPulseData.get(i);
			SingleBarValuesComparableVO singleBarValuesVO = new SingleBarValuesComparableVO();
			
			singleBarValuesVO.setX(DateUtils.convertDateFormat(patientPulseObj.getvDate().toString()));
			singleBarValuesVO.setY(patientPulseObj.getPulse());
			
			singleBarValuesVOs.add(singleBarValuesVO);
		}
		
		//Sorting Arraylist below;
		Collections.sort(singleBarValuesVOs, new DatesComparator());
		
		singleBarDataMainVO.setValues(singleBarValuesVOs);
		singleBarDataMainVOs.add(singleBarDataMainVO);
		singleBarDataVO.setSingleBarData(singleBarDataMainVOs);
		
		return singleBarDataVO;
	}
	
	
	
	public static SingleBarDataVO convertPatientHeightDataForSingleBar(List<PatientHeightDTO> patientHeightData){
		SingleBarDataVO singleBarDataVO = new SingleBarDataVO();
		List<SingleBarDataMainVO> singleBarDataMainVOs = new ArrayList<SingleBarDataMainVO>();
		List<SingleBarValuesVO> singleBarValuesVOs = new ArrayList<SingleBarValuesVO>();
		SingleBarDataMainVO singleBarDataMainVO = new SingleBarDataMainVO();
		
		singleBarDataMainVO.setKey("Patient Height");
		singleBarDataMainVO.setColor("#9C344C");
		
		for (int i = 0; i<patientHeightData.size(); i++) {
			PatientHeightDTO patientHeightObj =  patientHeightData.get(i);
			SingleBarValuesVO singleBarValuesVO = new SingleBarValuesVO();
			
			singleBarValuesVO.setX(DateUtils.convertDateFormat(patientHeightObj.getvDate().toString()));
			singleBarValuesVO.setY(patientHeightObj.getHeight());
			
			singleBarValuesVOs.add(singleBarValuesVO);
		}
		
		singleBarDataMainVO.setValues(singleBarValuesVOs);
		singleBarDataMainVOs.add(singleBarDataMainVO);
		singleBarDataVO.setSingleBarData(singleBarDataMainVOs);
		
		return singleBarDataVO;
	}
	
	
	
	public static SingleBarDataComparableVO convertPatientWeightDataForSingleBar(List<PatientWeightDTO> patientWeightData){
		SingleBarDataComparableVO singleBarDataVO = new SingleBarDataComparableVO();
		List<SingleBarDataMainComparableVO> singleBarDataMainVOs = new ArrayList<SingleBarDataMainComparableVO>();
		List<SingleBarValuesComparableVO> singleBarValuesVOs = new ArrayList<SingleBarValuesComparableVO>();
		SingleBarDataMainComparableVO singleBarDataMainVO = new SingleBarDataMainComparableVO();
		
		singleBarDataMainVO.setKey("Patient Weight");
		
		for (int i = 0; i<patientWeightData.size(); i++) {
			PatientWeightDTO patientWeightObj =  patientWeightData.get(i);
			SingleBarValuesComparableVO singleBarValuesVO = new SingleBarValuesComparableVO();
			
			singleBarValuesVO.setX(DateUtils.convertDateFormat(patientWeightObj.getvDate().toString()));
			singleBarValuesVO.setY(patientWeightObj.getWeight());
			
			singleBarValuesVOs.add(singleBarValuesVO);
		}
		
		//Sorting Arraylist below;
		Collections.sort(singleBarValuesVOs, new DatesComparator());

		singleBarDataMainVO.setValues(singleBarValuesVOs);
		singleBarDataMainVOs.add(singleBarDataMainVO);
		singleBarDataVO.setSingleBarData(singleBarDataMainVOs);
		
		return singleBarDataVO;
	}
	
	
	
	public static PatientBMIDTO convertPatientBMIData(ResultSet res){
		PatientBMIDTO patientBMIDTO = new PatientBMIDTO();
		try{
			while (res.next()){
					patientBMIDTO.setvDate(res.getDate(1));
					patientBMIDTO.setWeight(res.getDouble(2));
					patientBMIDTO.setHeight(res.getDouble(3));
					patientBMIDTO.setBmi(MathsUtils.calculateBMI(res.getDouble(2), res.getDouble(3)));
			}
		}catch(Exception e){
			
		}
		
		return patientBMIDTO;
	}
	
	
	
	
	
	//Old Methods for Pulse, Weight and blood pressure below;
//	public static SingleBarDataVO convertPatientPulseDataForSingleBar(List<PatientPulseDTO> patientPulseData){
//		SingleBarDataVO singleBarDataVO = new SingleBarDataVO();
//		List<SingleBarDataMainVO> singleBarDataMainVOs = new ArrayList<SingleBarDataMainVO>();
//		List<SingleBarValuesVO> singleBarValuesVOs = new ArrayList<SingleBarValuesVO>();
//		SingleBarDataMainVO singleBarDataMainVO = new SingleBarDataMainVO();
//		
//		singleBarDataMainVO.setKey("Pulse");
//		singleBarDataMainVO.setColor("#8CC152");
//		
//		for (int i = 0; i<patientPulseData.size(); i++) {
//			PatientPulseDTO patientPulseObj =  patientPulseData.get(i);
//			SingleBarValuesVO singleBarValuesVO = new SingleBarValuesVO();
//			
//			singleBarValuesVO.setX(DateUtils.convertDateFormat(patientPulseObj.getvDate().toString()));
//			singleBarValuesVO.setY(patientPulseObj.getPulse());
//			
//			singleBarValuesVOs.add(singleBarValuesVO);
//		}
//		
//		singleBarDataMainVO.setValues(singleBarValuesVOs);
//		singleBarDataMainVOs.add(singleBarDataMainVO);
//		singleBarDataVO.setSingleBarData(singleBarDataMainVOs);
//		
//		return singleBarDataVO;
//	}
	
	
//	public static SingleBarDataVO convertPatientWeightDataForSingleBar(List<PatientWeightDTO> patientWeightData){
//		SingleBarDataVO singleBarDataVO = new SingleBarDataVO();
//		List<SingleBarDataMainVO> singleBarDataMainVOs = new ArrayList<SingleBarDataMainVO>();
//		List<SingleBarValuesVO> singleBarValuesVOs = new ArrayList<SingleBarValuesVO>();
//		SingleBarDataMainVO singleBarDataMainVO = new SingleBarDataMainVO();
//		
//		singleBarDataMainVO.setKey("Patient Weight");
//		
//		for (int i = 0; i<patientWeightData.size(); i++) {
//			PatientWeightDTO patientWeightObj =  patientWeightData.get(i);
//			SingleBarValuesVO singleBarValuesVO = new SingleBarValuesVO();
//			
//			singleBarValuesVO.setX(DateUtils.convertDateFormat(patientWeightObj.getvDate().toString()));
//			singleBarValuesVO.setY(patientWeightObj.getWeight());
//			
//			singleBarValuesVOs.add(singleBarValuesVO);
//		}
//		
//		singleBarDataMainVO.setValues(singleBarValuesVOs);
//		singleBarDataMainVOs.add(singleBarDataMainVO);
//		singleBarDataVO.setSingleBarData(singleBarDataMainVOs);
//		
//		return singleBarDataVO;
//	}
	
	
//	public static SingleBarDataVO convertPatientBloodPressureDataForSingleBar(List<PatientBloodPressureDTO> patientBloodPressureData){
//		SingleBarDataVO singleBarDataVO = new SingleBarDataVO();
//		List<SingleBarDataMainVO> singleBarDataMainVOs = new ArrayList<SingleBarDataMainVO>();
////		VO below will be commented out totally;
////		List<SingleBarValuesVO> singleBarValuesVOs = new ArrayList<SingleBarValuesVO>();
//		
////		New VO's for Blood Pressure Systolic and Diastolic readings;
//		List<SingleBarValuesVO> singleBarSystolicValuesVOs = new ArrayList<SingleBarValuesVO>();
//		List<SingleBarValuesVO> singleBarDiastolicValuesVOs = new ArrayList<SingleBarValuesVO>();
//		
////		SingleBarDataMainVO singleBarDataMainVO = new SingleBarDataMainVO();
//		
//		
//		for(int i=0; i<2; i++){
//			SingleBarDataMainVO singleBarDataMainVO1 = new SingleBarDataMainVO();
//			
//			if(i==0){
//				singleBarDataMainVO1.setKey("Systolic");
//			}else if(i==1){
//				singleBarDataMainVO1.setKey("Diastolic");
//			}
//			
//			//for loop below;
//			for (int j = 0; j<patientBloodPressureData.size(); j++) {
//				PatientBloodPressureDTO patientBloodPressureObj =  patientBloodPressureData.get(j);
//				
//				if(i==0){
////					work below for 'Systolic' readings;
//					SingleBarValuesVO singleBarSystolicValuesVO = new SingleBarValuesVO();
//					singleBarSystolicValuesVO.setX(DateUtils.convertDateFormat(patientBloodPressureObj.getvDate().toString()));
//					singleBarSystolicValuesVO.setY(patientBloodPressureObj.getbPresu());
//					singleBarSystolicValuesVOs.add(singleBarSystolicValuesVO);
//					singleBarDataMainVO1.setValues(singleBarSystolicValuesVOs);
//				}else if(i==1){
////					work below for 'Diastolic' readings;
//					SingleBarValuesVO singleBarDiastolicValuesVO = new SingleBarValuesVO();
//					singleBarDiastolicValuesVO.setX(DateUtils.convertDateFormat(patientBloodPressureObj.getvDate().toString()));
//					singleBarDiastolicValuesVO.setY(patientBloodPressureObj.getbPresd());
//					singleBarDiastolicValuesVOs.add(singleBarDiastolicValuesVO);
//					singleBarDataMainVO1.setValues(singleBarDiastolicValuesVOs);
//				}
//			}
//
//			singleBarDataMainVOs.add(singleBarDataMainVO1);
//			singleBarDataVO.setSingleBarData(singleBarDataMainVOs);
//		}
//		
//		return singleBarDataVO;
//	}	



}
