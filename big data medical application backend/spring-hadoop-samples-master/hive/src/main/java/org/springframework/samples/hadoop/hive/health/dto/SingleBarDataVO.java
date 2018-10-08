package org.springframework.samples.hadoop.hive.health.dto;

import java.util.List;

public class SingleBarDataVO {
	
	private List<SingleBarDataMainVO> singleBarData;
	
	
	
	public List<SingleBarDataMainVO> getSingleBarData() {
		return singleBarData;
	}
	public void setSingleBarData(List<SingleBarDataMainVO> singleBarData) {
		this.singleBarData = singleBarData;
	}
	
}
