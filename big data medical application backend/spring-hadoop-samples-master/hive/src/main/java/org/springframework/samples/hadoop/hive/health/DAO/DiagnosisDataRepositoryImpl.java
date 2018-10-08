package org.springframework.samples.hadoop.hive.health.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.samples.hadoop.hive.health.dto.DiagnosisDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.stereotype.Repository;

@Repository
public class DiagnosisDataRepositoryImpl implements DiagnosisDataRepository {
	
	private static final Log log = LogFactory.getLog(DiagnosisDataRepositoryImpl.class);

	private String diagnosisDataTable = "diagnosis_data";
	
	@Autowired
	private SimpleDriverDataSource hiveDataSource;

	
//	db properties;
	private Connection con;
	private Statement stmt;
	private ResultSet res;
	
	
	
	public ResponseDTO saveDiagnosisRecord(DiagnosisDataJSONDTO diagnosisData){
		ResponseDTO responseDTO = new ResponseDTO();
		try{
		  	  con = hiveDataSource.getConnection();
		  	  stmt = con.createStatement();

		  	  String sql = "insert into "+diagnosisDataTable+" values('"+diagnosisData.getPersonId()+"', 1, '"+diagnosisData.getDcode()+"', '"+diagnosisData.getDiagnosis()+"')";
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
