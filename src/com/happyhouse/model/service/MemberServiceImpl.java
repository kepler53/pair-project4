package com.happyhouse.model.service;

import java.sql.SQLException;

import com.happyhouse.model.DAO.MemberDAO;
import com.happyhouse.model.DAO.MemberDAOImpl;
import com.happyhouse.model.DTO.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	MemberDAO memberDAO;
	
	 public MemberServiceImpl() {
		 memberDAO = new MemberDAOImpl();
	}

	@Override
	public MemberDTO login(String userid, String userpwd) throws SQLException {
		// TODO Auto-generated method stub
		return memberDAO.login(userid, userpwd);
	}

	@Override
	public int insert(MemberDTO memberDTO) throws SQLException {
		// TODO Auto-generated method stub
		return memberDAO.insert(memberDTO);
	}

}
