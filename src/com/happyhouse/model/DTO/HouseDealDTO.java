package com.happyhouse.model.DTO;

public class HouseDealDTO {

	private String dong;
	private String AptName;
	private String code;
	private float dealAmount;
	private float buildYear;
	
	@Override
	public String toString() {
		return "HouseDealDTO [dong=" + dong + ", AptName=" + AptName + ", code=" + code + ", dealAmount=" + dealAmount
				+ ", buildYear=" + buildYear + "]";
	}

	public HouseDealDTO() {}

	public HouseDealDTO(String dong, String aptName, String code, float dealAmount, float buildYear) {
		super();
		this.dong = dong;
		AptName = aptName;
		this.code = code;
		this.dealAmount = dealAmount;
		this.buildYear = buildYear;
	}

	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		AptName = aptName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public float getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(float dealAmount) {
		this.dealAmount = dealAmount;
	}
	public float getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(float buildYear) {
		this.buildYear = buildYear;
	}
	

}
