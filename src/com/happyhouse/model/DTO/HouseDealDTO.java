package com.happyhouse.model.DTO;

public class HouseDealDTO {

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public float getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(float buildYear) {
		this.buildYear = buildYear;
	}

	private String dong;
	private String aptName;
	private String code;
	private String dealAmount;
	private float buildYear;
	
	public HouseDealDTO() {
		
	}
	
	public HouseDealDTO(String dong, String aptName, String code, String dealAmount, float buildYear) {
		super();
		this.dong = dong;
		this.aptName = aptName;
		this.code = code;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
	}
	
	
	

}
