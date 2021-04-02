package com.happyhouse.model.DTO;

public class MemberDTO {

	private String userid;
	private String userpwd;
	private String useremail;



	//constructor
	public MemberDTO() {

	}
	public MemberDTO(String userid, String userpwd, String useremail) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.useremail = useremail;
	}


	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


}
