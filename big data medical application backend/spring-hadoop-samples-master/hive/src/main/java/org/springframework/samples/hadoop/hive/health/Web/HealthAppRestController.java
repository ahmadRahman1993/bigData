package org.springframework.samples.hadoop.hive.health.Web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.hadoop.hive.health.Service.AddmissionDataService;
import org.springframework.samples.hadoop.hive.health.Service.DiagnosisDataService;
import org.springframework.samples.hadoop.hive.health.Service.LabDataService;
import org.springframework.samples.hadoop.hive.health.Service.PatientDataService;
import org.springframework.samples.hadoop.hive.health.Service.PatientVitalsService;
import org.springframework.samples.hadoop.hive.health.dto.AddmissionDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.DiagnosisDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.LabDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.LabDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientBMIDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByIdDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataByNameDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.PatientVitalsJSONDTO;
import org.springframework.samples.hadoop.hive.health.dto.ResponseDTO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarDataComparableVO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarDataVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthAppRestController {
	
    private static final Log log = LogFactory.getLog(HealthAppRestController.class);

	
    @Autowired
    private PatientDataService patientDataService; 
	
    @Autowired
    private PatientVitalsService patientVitalsService; 

    @Autowired
    private AddmissionDataService addmissionService; 
    
    @Autowired
    private DiagnosisDataService diagnosisService; 

    @Autowired
    private LabDataService labService; 

    
    
    
    @RequestMapping(value = "/getLimittedPatientDataRecs", method = RequestMethod.GET)
    public @ResponseBody
    List<PatientDataDTO> getLimittedPatientDataRecsJSON() {
    	
        List<PatientDataDTO> PatientsData = patientDataService.getLimittedPatientDataRecs();

        log.debug("******************** PatientsData list: ******************");

        return PatientsData;
    }
	
    
    @RequestMapping(value = "/getPatientDataByCriteria/name/{personName}/age/{personAge}/contactno/{contactNo}", method = RequestMethod.GET)
    public @ResponseBody
    List<PatientDataByNameDTO> getPatientDataByNameJSON(@PathVariable String personName, @PathVariable int personAge, @PathVariable String contactNo) {
    	
        List<PatientDataByNameDTO> PatientsData = patientDataService.getPatientDataByCriteria(personName, personAge, contactNo);

        log.debug("******************** PatientDataByCriteria: ******************");

        return PatientsData;
    }


    @RequestMapping(value = "/getPatientDataById/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    PatientDataDTO getPatientDataByIdJSON(@PathVariable String personId) {
    	
        PatientDataDTO patientData = patientDataService.getPatientDataById(personId);

        log.debug("******************** PatientDataById: ******************");

        return patientData;
    }

    
    @RequestMapping(value = "/getLabResultsByPatientId/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    List<LabDataDTO> getLabResultsByPatientIdJSON(@PathVariable String personId) {
    	
        List<LabDataDTO> labData = labService.getLabResultsByPatientId(personId);

        log.debug("******************** LabResultsByPatientId: ******************");

        return labData;
    }

    
    @RequestMapping(value = "/getPatientBloodPressureDataById/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    SingleBarDataComparableVO getPatientBloodPressureDataByIdJSON(@PathVariable String personId) {
    	
    	SingleBarDataComparableVO patientBloodPressureData = patientVitalsService.getPatientBloodPressureDataById(personId);

        log.debug("******************** PatientBloodPressureDataById: ******************");

        return patientBloodPressureData;
    	
    }

    
    
    @RequestMapping(value = "/getPatientBodyTempDataById/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    SingleBarDataVO getPatientBodyTempDataByIdJSON(@PathVariable String personId) {
    	
    	SingleBarDataVO patientBodyTempData = patientVitalsService.getPatientBodyTempDataById(personId);

        log.debug("******************** PatientBodyTempDataById: ******************");

        return patientBodyTempData;
    	
    }

    
    
    @RequestMapping(value = "/getPatientPulseDataById/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    SingleBarDataComparableVO getPatientPulseDataByIdJSON(@PathVariable String personId) {
    	
    	SingleBarDataComparableVO patientPulseData = patientVitalsService.getPatientPulseDataById(personId);

        log.debug("******************** PatientPulseDataById: ******************");

        return patientPulseData;
    	
    }
    
    
    
    @RequestMapping(value = "/getPatientHeightDataById/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    SingleBarDataVO getPatientHeightDataByIdJSON(@PathVariable String personId) {
    	
    	SingleBarDataVO patientHeightData = patientVitalsService.getPatientHeightDataById(personId);

        log.debug("******************** PatientHeightDataById: ******************");

        return patientHeightData;
    	
    }

    
    
    @RequestMapping(value = "/getPatientWeightDataById/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    SingleBarDataComparableVO getPatientWeightDataByIdJSON(@PathVariable String personId) {
    	
    	SingleBarDataComparableVO patientWeightData = patientVitalsService.getPatientWeightDataById(personId);

        log.debug("******************** PatientWeightDataById: ******************");

        return patientWeightData;
    	
    }
    
    
    
    @RequestMapping(value = "/getPatientBMIDataById/{personId}", method = RequestMethod.GET)
    public @ResponseBody
    PatientBMIDTO getPatientDMIDataByIdJSON(@PathVariable String personId) {
    	
    	PatientBMIDTO patientBMIData = patientVitalsService.getPatientBMIDataById(personId);

        log.debug("******************** PatientBMIDataById: ******************");

        return patientBMIData;
    	
    }
    
    
    @RequestMapping(value = "/saveOrUpdatePatientData", method = RequestMethod.POST, headers="accept=application/json")
    public @ResponseBody
    ResponseDTO saveOrUpdatePatientDataJSON(@RequestBody PatientDataJSONDTO patientData) {
    	ResponseDTO responseDTO = new ResponseDTO();
    	responseDTO = patientDataService.saveOrUpdatePatientRecord(patientData);

        log.debug("******************** SaveOrUpdatePatientData: ******************");
        return responseDTO;
    }
    
    
    
    @RequestMapping(value = "/saveAddmissionData", method = RequestMethod.POST, headers="accept=application/json")
    public @ResponseBody
    ResponseDTO saveAddmissionDataJSON(@RequestBody AddmissionDataJSONDTO addmissionData) {
    	ResponseDTO responseDTO = new ResponseDTO();
    	responseDTO = addmissionService.saveAddmissionRecord(addmissionData);

        log.debug("******************** SaveAddmissionData: ******************");
        return responseDTO;
    }

    
    
    @RequestMapping(value = "/saveDiagnosisData", method = RequestMethod.POST, headers="accept=application/json")
    public @ResponseBody
    ResponseDTO saveDiagnosisDataJSON(@RequestBody DiagnosisDataJSONDTO diagnosisData) {
    	ResponseDTO responseDTO = new ResponseDTO();
    	responseDTO = diagnosisService.saveDiagnosisRecord(diagnosisData);

        log.debug("******************** SaveDiagnosisData: ******************");
        return responseDTO;
    }
    
    
    @RequestMapping(value = "/saveLabData", method = RequestMethod.POST, headers="accept=application/json")
    public @ResponseBody
    ResponseDTO saveLabDataJSON(@RequestBody LabDataJSONDTO labData) {
    	ResponseDTO responseDTO = new ResponseDTO();
    	responseDTO = labService.saveLabDataRecord(labData);

        log.debug("******************** SaveLabData: ******************");
        return responseDTO;
    }
    
    
    @RequestMapping(value = "/savePatientVitalsData", method = RequestMethod.POST, headers="accept=application/json")
    public @ResponseBody
    ResponseDTO savePatientVitalsDataJSON(@RequestBody PatientVitalsJSONDTO patientVitals) {
    	ResponseDTO responseDTO = new ResponseDTO();
    	responseDTO = patientVitalsService.savePatientVitalsRecord(patientVitals);

        log.debug("******************** SavePatientVitalsData: ******************");
        
        return responseDTO;
    }
    
    
    
    
    
    
    
//    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
//    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    
    @RequestMapping(value = "/saveOrUpdatePatientTestData", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO saveOrUpdatePatientTestDataJSON() {
    	ResponseDTO responseDTO = new ResponseDTO();
		PatientDataJSONDTO patientData = new PatientDataJSONDTO();
		patientData.setAge("38");
		patientData.setContact("(0300) 123-4064");
		patientData.setDob("1978-09-18");
		patientData.setGender("Male");
		patientData.setMaritalStatus("Married");
		
//		patient id is 'non 0' in case of SAVE
//		patientData.setPersonId("PD-01");
//		patient id is '0' in case of UPDATE
		patientData.setPersonId("0");
		
		patientData.setPersonName("Mazhar Ali");
		patientData.setpLanguage("Sindhi");
		patientData.setpPercent("96.66");
		patientData.setRace("Central Asian");

		responseDTO = patientDataService.saveOrUpdatePatientRecord(patientData);
		return responseDTO;
    }

    
    @RequestMapping(value = "/saveAddmissionTestData", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO saveAddmissionTestDataJSON() {
    	ResponseDTO responseDTO = new ResponseDTO();
		AddmissionDataJSONDTO addmissionData = new AddmissionDataJSONDTO();

		addmissionData.setPersonId("AD-002");
		addmissionData.setAddmissionId("001");
		addmissionData.setStartDate("1990-01-01");
		addmissionData.setEndDate("1990-01-02");
		
		responseDTO = addmissionService.saveAddmissionRecord(addmissionData);
		return responseDTO;
    }
    
    
    @RequestMapping(value = "/saveDiagnosisTestData", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO saveDiagnosisTestDataJSON() {
    	ResponseDTO responseDTO = new ResponseDTO();
    	DiagnosisDataJSONDTO diagnosisData = new DiagnosisDataJSONDTO();

    	diagnosisData.setPersonId("DD-003");
    	diagnosisData.setAddmissionId("002");
    	diagnosisData.setDcode("DCODE-003");
    	diagnosisData.setDiagnosis("Test Diagnosis-03");
    	
    	responseDTO = diagnosisService.saveDiagnosisRecord(diagnosisData);
    	return responseDTO;
    }
    
    
    @RequestMapping(value = "/saveLabTestData", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO saveLabTestDataJSON() {
    	ResponseDTO responseDTO = new ResponseDTO();
    	LabDataJSONDTO labData = new LabDataJSONDTO();

    	labData.setPersonId("LD-003");
    	labData.setAddmissionId("002");
    	labData.setLabName("Anab-003");
    	labData.setLabValue("33.33");
    	labData.setLabUnits("DG/MLL");
    	labData.setlDate("1930-12-12");
    	
    	responseDTO = labService.saveLabDataRecord(labData);
    	return responseDTO;
    }
    
    
    @RequestMapping(value = "/savePatientVitalsTestData", method = RequestMethod.GET)
    public @ResponseBody
    ResponseDTO savePatientVitalsTestDataJSON() {
    	ResponseDTO responseDTO = new ResponseDTO();
    	PatientVitalsJSONDTO patientVitals = new PatientVitalsJSONDTO();
    	
    	patientVitals.setPersonId("PV-005");
    	patientVitals.setHeight("190.1901");
    	patientVitals.setWeight("80.888");
    	patientVitals.setPulse("110.105");
    	patientVitals.setBpresu("72.777");
    	patientVitals.setBpresd("125.121");
    	patientVitals.setBtemp("98.999");
    	patientVitals.setVdate("1930-01-01");
    	
    	responseDTO = patientVitalsService.savePatientVitalsRecord(patientVitals);
    	return responseDTO;
    }

}
