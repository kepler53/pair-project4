package com.happyhouse.model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happyhouse.model.DTO.HouseDealDTO;

public interface HouseDealService {

	//동 코드에 맞는 정보 검색
	public List<HouseDealDTO> search(String dongcode) throws Exception;
	
	
}
