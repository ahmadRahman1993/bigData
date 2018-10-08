package org.springframework.samples.hadoop.hive.health.utils;

import java.util.Comparator;

import org.springframework.samples.hadoop.hive.health.dto.SingleBarValuesComparableVO;
import org.springframework.samples.hadoop.hive.health.dto.SingleBarValuesVO;



public class DatesComparator implements Comparator<SingleBarValuesComparableVO>{
	
	//implementing method comparator;
	public int compare(SingleBarValuesComparableVO singleBarValuesComparableVO1, SingleBarValuesComparableVO singleBarValuesComparableVO2){
		if(singleBarValuesComparableVO1.getX().before(singleBarValuesComparableVO2.getX()))
			return 1;
		else if(singleBarValuesComparableVO2.getX().before(singleBarValuesComparableVO1.getX()))
			return -1;
		else 
			return 0;
	}
	
}
