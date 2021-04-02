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
	public MemberDTO login(String userid, String userpwd) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.login(userid, userpwd);
	}

	@Override
	public int insert(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.insert(memberDTO);
	}

	@Override
	public int delete(String id) throws Exception {		
		return memberDAO.delete(id);
	}

	@Override
	public int update(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.update(memberDTO);
	}
	
}
