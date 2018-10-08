package org.springframework.samples.hadoop.hive.health.dto;

import java.util.List;

public class SingleBarDataMainComparableVO {
	
	private String key;
	private String color;
	private List<SingleBarValuesComparableVO> values;
	
	
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public List<SingleBarValuesComparableVO> getValues() {
		return values;
	}
	public void setValues(List<SingleBarValuesComparableVO> values) {
		this.values = values;
	}
	
}
