package com.happyhouse.model.service;

import java.util.ArrayList;
import java.util.List;

import com.happyhouse.model.DAO.HouseDealDAO;
import com.happyhouse.model.DAO.HouseDealDAOImpl;
import com.happyhouse.model.DAO.MemberDAO;
import com.happyhouse.model.DAO.MemberDAOImpl;
import com.happyhouse.model.DTO.HouseDealDTO;

public class HouseDealServiceImpl implements HouseDealService {
	
	HouseDealDAO houseDealDAO;
	
	 public HouseDealServiceImpl() {
		 houseDealDAO = new HouseDealDAOImpl();
	}

	@Override
	public List<HouseDealDTO> search(String dongcode) throws Exception {
		// TODO Auto-generated method stub
		return houseDealDAO.search(dongcode);
	}

	
	
}
