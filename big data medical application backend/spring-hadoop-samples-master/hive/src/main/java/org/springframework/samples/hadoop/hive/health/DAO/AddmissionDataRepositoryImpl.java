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
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public class AddmissionDataRepositoryImpl implements AddmissionDataRepository {
	
	private static final Log log = LogFactory.getLog(AddmissionDataRepositoryImpl.class);

	private String addmissionDatatable = "addmission_data";
	
	@Autowired
	private SimpleDriverDataSource hiveDataSource;

	
//	db properties;
	private Connection con;
	private Statement stmt;
	private ResultSet res;

	
	@Override
	public List<AddmissionDataDTO> getAllAddmissionDataRecs(){
		List<AddmissionDataDTO> addmissionDataDTOs = new ArrayList<AddmissionDataDTO>();
		try{
		  	  con = hiveDataSource.getConnection();
		      stmt = con.createStatement();
		      
		      // select * query
		      String sql = "select * from " + addmissionDatatable + " limit 5 ";
		      log.info("Running: " + sql);
		      res = stmt.executeQuery(sql);
		      addmissionDataDTOs = ETDConverter.getAllAddmissionDataRecs(res);
		      
		      con.close();
		}catch(Exception e){
			
		}
		return addmissionDataDTOs;
	}
	
	
	public ResponseDTO saveAddmissionRecord(AddmissionDataJSONDTO addmissionData){
		ResponseDTO responseDTO = new ResponseDTO();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  stmt = con.createStatement();

		  	  String sql = "insert into "+addmissionDatatable+" values('"+addmissionData.getPersonId()+"', 1, '"+addmissionData.getStartDate()+"', '"+addmissionData.getEndDate()+"')";
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
