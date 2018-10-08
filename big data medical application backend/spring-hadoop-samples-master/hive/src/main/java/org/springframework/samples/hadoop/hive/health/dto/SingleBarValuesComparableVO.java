package org.springframework.samples.hadoop.hive.health.dto;

import java.sql.Timestamp;
import java.util.Date;

public class SingleBarValuesComparableVO implements Comparable<SingleBarValuesComparableVO> {
	
	private Timestamp x;
	private Double y;
	
	
	
	public Timestamp getX() {
		return x;
	}
	public void setX(Timestamp x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	
	
	//implementing method compareTo;
	@Override
	public int compareTo(SingleBarValuesComparableVO singleBarValuesVO){
		return this.x.compareTo(singleBarValuesVO.x);
	}
	
}
