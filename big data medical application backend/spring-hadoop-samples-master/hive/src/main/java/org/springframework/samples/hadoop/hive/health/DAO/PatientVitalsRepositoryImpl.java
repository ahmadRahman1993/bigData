package org.springframework.samples.hadoop.hive.health.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.samples.hadoop.hive.health.dto.ETDConverter;
import org.springframework.samples.hadoop.hive.health.dto.PatientBMIDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientBloodPressureDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientBodyTempDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientHeightDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientPulseDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientVitalsJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientWeightDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public class PatientVitalsRepositoryImpl implements PatientVitalsRepository {
	
	private static final Log log = LogFactory.getLog(PatientVitalsRepositoryImpl.class);

	private String patientVitalsTable = "patient_vitals";

	@Autowired
	private SimpleDriverDataSource hiveDataSource;

	
//	db properties;
	private Connection con;
	private Statement stmt;
	private ResultSet res;

	
	public List<PatientBloodPressureDTO> getPatientBloodPressureDataById(String personId){
		List<PatientBloodPressureDTO> patientBloodPressureData = new ArrayList<PatientBloodPressureDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
		  	  
		  	  String sql = "select vdate, bpresu, bpresd from " + patientVitalsTable + " where personid like '%"+personId+"%'";
		  	  
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  
		      log.info("Running: " + sql);
		      patientBloodPressureData = ETDConverter.getPatientBloodPressureDataById(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientBloodPressureData;
	}


	
	public List<PatientBodyTempDTO> getPatientBodyTempDataById(String personId){
		List<PatientBodyTempDTO> patientBodyTempData = new ArrayList<PatientBodyTempDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
		  	  
		  	  String sql = "select vdate, btemp from " + patientVitalsTable + " where personid like '%"+personId+"%'";
		  	  
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  
		      log.info("Running: " + sql);
		      patientBodyTempData = ETDConverter.convertPatientBodyTempData(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientBodyTempData;
	}
	
	
	
	public List<PatientPulseDTO> getPatientPulseDataById(String personId){
		List<PatientPulseDTO> patientPulseData = new ArrayList<PatientPulseDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
		  	  
		  	  String sql = "select vdate, pulse from " + patientVitalsTable + " where personid like '%"+personId+"%'";
		  	  
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  
		      log.info("Running: " + sql);
		      patientPulseData = ETDConverter.convertPatientPulseData(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientPulseData;
	}
	
	
	
	public List<PatientHeightDTO> getPatientHeightDataById(String personId){
		List<PatientHeightDTO> patientHeightData = new ArrayList<PatientHeightDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
		  	  
		  	  String sql = "select vdate, height from " + patientVitalsTable + " where personid like '%"+personId+"%'";
		  	  
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  
		      log.info("Running: " + sql);
		      patientHeightData = ETDConverter.convertPatientHeightData(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientHeightData;
	}
	
	
	
	public List<PatientWeightDTO> getPatientWeightDataById(String personId){
		List<PatientWeightDTO> patientWeightData = new ArrayList<PatientWeightDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
		  	  
		  	  String sql = "select vdate, weight from " + patientVitalsTable + " where personid like '%"+personId+"%'";
		  	  
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  
		      log.info("Running: " + sql);
		      patientWeightData = ETDConverter.convertPatientWeightData(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientWeightData;
	}
	
	
	public PatientBMIDTO getPatientBMIDataById(String personId){
		PatientBMIDTO patientBMI = new PatientBMIDTO();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
		  	  
		  	  String sql = "select vdate, weight, height from " + patientVitalsTable + " where personid like '%"+personId+"%'";
		  	  
//		  	  stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  	  
		      log.info("Running: " + sql);
//		      res.last();
//		      System.out.println(res.getFetchSize());
//		      System.out.println("####################################################### Result Set should be at last position");
//		      System.out.println(res.getDate(1));
//		      System.out.println(res.getDouble(2));
		      patientBMI = ETDConverter.convertPatientBMIData(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientBMI;
	}
	
	
	public ResponseDTO savePatientVitalsRecord(PatientVitalsJSONDTO patientVitals){
		ResponseDTO responseDTO = new ResponseDTO();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  stmt = con.createStatement();

		  	  String sql = "insert into "+patientVitalsTable+" values('"+patientVitals.getPersonId()+"' ,"+Double.parseDouble(patientVitals.getHeight())+","+Double.parseDouble(patientVitals.getWeight())+","+Double.parseDouble(patientVitals.getPulse())+","+Double.parseDouble(patientVitals.getBpresu())+","+Double.parseDouble(patientVitals.getBpresd())+","+Double.parseDouble(patientVitals.getBtemp())+", '"+patientVitals.getVdate()+"')";
		  	  log.info("Running: " + sql);
		  	  stmt.executeUpdate(sql);
		      
		      con.close();
		      responseDTO.setResponseCode("201");
		}catch(Exception e){
			responseDTO.setResponseCode("500");
			return responseDTO;
		}
		return responseDTO;
	}
	
	
	
}
