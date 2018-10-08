package org.springframework.samples.hadoop.hive.health.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ETDConverter;
import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.LabDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public class LabDataRepositoryImpl implements LabDataRepository {
	
	private static final Log log = LogFactory.getLog(LabDataRepositoryImpl.class);

	private String labDataTable = "lab_data";
	
	@Autowired
	private SimpleDriverDataSource hiveDataSource;

	
//	db properties;
	private Connection con;
	private Statement stmt;
	private ResultSet res;

	
	public List<LabDataDTO> getLabResultsByPatientId(String personId){
		List<LabDataDTO> patientDataById = new ArrayList<LabDataDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxx PERSON ID IS : "+personId);
		  	  
		  	  String sql = "select labname, labvalue, labunits, ldate from " + labDataTable + " where personid like '%"+personId+"%'";
		  	  
		  	  stmt = con.createStatement();
		  	  res = stmt.executeQuery(sql);
		  
		      log.info("Running: " + sql);
		      patientDataById = ETDConverter.getLabResultsByPatientId(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return patientDataById;
	}
	
	
	public ResponseDTO saveLabDataRecord(LabDataJSONDTO labData){
		ResponseDTO responseDTO = new ResponseDTO();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  stmt = con.createStatement();

		  	  String sql = "insert into "+labDataTable+" values('"+labData.getPersonId()+"', 1, '"+labData.getLabName()+"',"+Double.parseDouble(labData.getLabValue())+" ,'"+labData.getLabUnits()+"', '"+labData.getlDate()+"')";
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
