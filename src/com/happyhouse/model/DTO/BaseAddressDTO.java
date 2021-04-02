package com.happyhouse.model.DTO;

public class BaseAddressDTO {

	private String city;
	private String dongcode;
	private String gugun;
	private float lat;
	private float lng;
	
	public BaseAddressDTO() {}
	public BaseAddressDTO(String city, String dongcode, String gugun, float lat, float lng) {
		super();
		this.city = city;
		this.dongcode = dongcode;
		this.gugun = gugun;
		this.lat = lat;
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "BaseAddressDTO [city=" + city + ", dongcode=" + dongcode + ", gugun=" + gugun + ", lat=" + lat
				+ ", lng=" + lng + "]";
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public float getLng() {
		return lng;
	}
	public void setLng(float lng) {
		this.lng = lng;
	}
}
