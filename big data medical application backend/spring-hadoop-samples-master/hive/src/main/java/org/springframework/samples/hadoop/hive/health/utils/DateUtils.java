package org.springframework.samples.hadoop.hive.health.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class DateUtils {
	
	public static Timestamp currentTimeStamp(Date date){
		return new Timestamp(date.getTime()); 
	}
	
	
	public static Timestamp convertDateFormat(String day){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsed;
		Date recDate = null;
		Timestamp dateTime = null;
		
		try{
			parsed = format.parse(day);
			recDate = new Date(parsed.getTime());
			dateTime = currentTimeStamp(recDate);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dateTime;
	}
	
}
