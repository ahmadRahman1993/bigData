/*
 * Copyright 2011-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.hadoop.hive;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.hadoop.hive.health.DAO.AddmissionDataRepository;
import org.springframework.samples.hadoop.hive.health.DAO.AddmissionDataRepositoryImpl;
import org.springframework.samples.hadoop.hive.health.Service.AddmissionDataService;
import org.springframework.samples.hadoop.hive.health.Service.AddmissionDataServiceImpl;
import org.springframework.samples.hadoop.hive.health.Service.PatientDataService;
import org.springframework.samples.hadoop.hive.health.Service.PatientDataServiceImpl;

public class HiveMedApp {

	private static final Log log = LogFactory.getLog(HiveMedApp.class);
	
//	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws Exception {
	      // Register driver and create driver instance
//	      try {   
	    	  
//	    	  Using Addmission DATA DAO;
	  		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
					"/META-INF/spring/hive-context.xml", HiveMedApp.class);
			log.info("Hive Medical Application Running");
			context.registerShutdownHook();
			
			
//			USING DAO;
//			AddmissionDataRepository addmissionRepo = context.getBean(AddmissionDataRepositoryImpl.class);
//			addmissionRepo.getAllAddmissionDataRecs();
			
			
//			USING SERVICES;
			AddmissionDataService addmissionService = context.getBean(AddmissionDataServiceImpl.class);
			PatientDataService patientService = context.getBean(PatientDataServiceImpl.class);
			
//			addmissionService.getAllAddmissionDataRecs();
			patientService.getLimittedPatientDataRecs();
//			patientService.getPatientDataByNameTest("Beatris Drane");
			
//	      } catch(Exception s) {
//	         s.printStackTrace();
//	      }
	      
		log.info("Hive Medical Application Completed");
	}
}
