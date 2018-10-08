package org.springframework.samples.hadoop.hive.health.dto;

import java.util.List;

public class SingleBarDataComparableVO {
	
	private List<SingleBarDataMainComparableVO> singleBarData;
	
	
	
	public List<SingleBarDataMainComparableVO> getSingleBarData() {
		return singleBarData;
	}
	public void setSingleBarData(List<SingleBarDataMainComparableVO> singleBarData) {
		this.singleBarData = singleBarData;
	}
	
}
