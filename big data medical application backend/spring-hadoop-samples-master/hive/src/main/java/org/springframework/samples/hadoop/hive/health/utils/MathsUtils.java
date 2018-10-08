package org.springframework.samples.hadoop.hive.health.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class MathsUtils {
	
	public static double calculateBMI(double weight, double height){
		double heightInMeters = height/100;
		
		return weight/(heightInMeters * heightInMeters);
	}
	
}
