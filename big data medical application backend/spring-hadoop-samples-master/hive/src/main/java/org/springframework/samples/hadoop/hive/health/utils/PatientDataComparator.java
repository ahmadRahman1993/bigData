package org.springframework.samples.hadoop.hive.health.utils;

import java.util.Comparator;

import org.springframework.samples.hadoop.hive.health.dto.PatientDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarValuesComparableVO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarValuesVO;



public class PatientDataComparator implements Comparator<PatientDataDTO>{
	
	//implementing method comparator;
	public int compare(PatientDataDTO patientData1, PatientDataDTO patientData2){
		if(patientData2.getCreatedDate() > patientData1.getCreatedDate())
			return 1;
		else if(patientData1.getCreatedDate() > patientData2.getCreatedDate())
			return -1;
		else 
			return 0;
	}
	
}
