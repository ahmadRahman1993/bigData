package org.springframework.samples.hadoop.hive.health.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.samples.hadoop.hive.health.dto.ETDConverter;
import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByIdDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByNameDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public class PatientDataRepositoryImpl implements PatientDataRepository {
	
	private static final Log log = LogFactory.getLog(PatientDataRepositoryImpl.class);

	private String patientDataTable = "patient_data";

//	private String labDataTable = "lab_data";
	

	@Autowired
	private SimpleDriverDataSource hiveDataSource;

	
//	db properties;
	private Connection con;
	private Statement stmt;
	private ResultSet res;

	
	@Override
	public List<PatientDataDTO> getLimittedPatientDataRecs(){
		List<PatientDataDTO> patientDataDTOs = new ArrayList<PatientDataDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		      stmt = con.createStatement();
		      
		      // select * query
//		      String sql = "select * from " + patientDataTable + " limit 5 ";
		      String sql = "select * from " + patientDataTable;
		      log.info("Running: " + sql);
		      res = stmt.executeQuery(sql);
		      patientDataDTOs = ETDConverter.convertPatientDataRecs(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientDataDTOs;
	}
	
	
	@Override
	public List<PatientDataByNameDTO> getPatientDataByCriteria(String personName, int personAge, String contactNo){
		List<PatientDataByNameDTO> patientDataDTOs = new ArrayList<PatientDataByNameDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  
		  	  String criteriaSql = null;
		  	  
		  	  if(personName.equals("0") && contactNo.equals("0") && personAge==0){
		  		criteriaSql = "";
		  	  }else{
			  	  if(!personName.equals("0") && !personName.isEmpty()){
				  		criteriaSql = " where lower(personname) like '%"+personName.toLowerCase()+"%'";
				  	}
			  	  if(personName.equals("0") && personAge != 0){
			  		criteriaSql = " where age like '%"+personAge+"%'";
			  	  }else if(personAge != 0){
			  		criteriaSql = criteriaSql+" and age like '%"+personAge+"%'";
			  	  }
			  	  if((personName.equals("0") || personAge == 0) && !contactNo.equals("0")){
			  		criteriaSql = " where contact like '%"+contactNo+"%'";
			  	  }else if(!contactNo.equals("0")){
			  		criteriaSql = criteriaSql+" and contact like '%"+contactNo+"%'";
			  	  }
		  	  }
		  	  
		  	  String sql = "select personid, personname, gender, dob, age, contact from " + patientDataTable + criteriaSql;
//		  	  String sql = "select * from " + patientDataTable + criteriaSql;
		  	  
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  
		      log.info("Running: " + sql);
		      patientDataDTOs = ETDConverter.getPatientDataByCriteria(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientDataDTOs;
	}
	
	
	public PatientDataDTO getPatientDataById(String personId){
		PatientDataDTO patientData = new PatientDataDTO();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
		  	  
		  	  String sql = "select * from " + patientDataTable + " where personid like '%"+personId+"%'";
		  	  
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  
		      log.info("Running: " + sql);
		      patientData = ETDConverter.convertPatientDataById(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientData;
	}
	
	
//	public List<LabDataDTO> getLabResultsByPatientId(String personId){
//		List<LabDataDTO> patientDataById = new ArrayList<LabDataDTO>();
//		try{
//		  	  con = hiveDataSource.getConnection();
//		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
//		  	  
//		  	  String sql = "select labname, labvalue, labunits, ldate from " + labDataTable + " where personid like '%"+personId+"%'";
//		  	  
//		  	  stmt = con.createStatement();
//		  	  res = stmt.executeQuery(sql);
//		  
//		      log.info("Running: " + sql);
//		      patientDataById = ETDConverter.getLabResultsByPatientId(res);
//		      
//		      con.close();
//		}catch(Exception e){
//			
//		}
//		return patientDataById;
//	}
	
	
//	Saving PatientData;
	public ResponseDTO savePatientRecord(PatientDataJSONDTO patientData){
		ResponseDTO responseDTO = new ResponseDTO();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  stmt = con.createStatement();

//		  	  String sql = "insert into patient_data values('AAA-05', 'MAK2', 'Male', null, 'Asian', 'Married', 'Unknown', 80.50, 38, '(0300) 123-4061')";
		  	  String sql = "insert into "+patientDataTable+" values('"+UUID.randomUUID().toString()+"', '"+patientData.getPersonName()+"', '"+patientData.getGender()+"', '"+patientData.getDob()+"', '"+patientData.getRace()+"', '"+patientData.getMaritalStatus()+"', '"+patientData.getpLanguage()+"', "+patientData.getpPercent()+", "+patientData.getAge()+", '"+patientData.getContact()+"', "+System.currentTimeMillis()+")";
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
	
	
	public ResponseDTO updatePatientRecord(PatientDataJSONDTO patientData){
		ResponseDTO responseDTO = new ResponseDTO();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  stmt = con.createStatement();

		  	  String sql = "update "+patientDataTable+" set personname = '"+patientData.getPersonName()+"', gender = '"+patientData.getGender()+"', dob = '"+patientData.getDob()+"', race = '"+patientData.getRace()+"', maritalstatus = '"+patientData.getMaritalStatus()+"', planguage = '"+patientData.getpLanguage()+"', ppercent = '"+patientData.getpPercent()+"', age = '"+patientData.getAge()+"', contact = '"+patientData.getContact()+"'  where personid = '"+patientData.getPersonId()+"'";
		  	  log.info("Running: " + sql);
		  	  stmt.executeUpdate(sql);
		      
		      con.close();
		      responseDTO.setResponseCode("200");
		}catch(Exception e){
			responseDTO.setResponseCode("500");
			return responseDTO;
		}
		return responseDTO;
	}
	

}
