package org.springframework.samples.hadoop.hive.health.Web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.hadoop.hive.health.Service.PatientDataService;
import org.springframework.samples.hadoop.hive.health.Service.PatientDataServiceImpl;
import org.springframework.samples.hadoop.hive.health.dto.PatientDataDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Home {
	String message = "Welcome to your 1st Maven Spring project !";
    

	@RequestMapping("/hello")
	public ModelAndView showMessage() {
		System.out.println("from controller");
		return new ModelAndView("hello", "message", message);
	}
	

}
