package com.happyhouse.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happyhouse.model.DTO.HouseDealDTO;
import com.happyhouse.util.DBUtil;



public class HouseDealDAOImpl implements HouseDealDAO {


	@Override
	public List<HouseDealDTO> search(String dongcode) throws SQLException {
		List<HouseDealDTO> list = new ArrayList<HouseDealDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			System.out.println(dongcode);
			String sql = "select dong, AptName, code, dealAmount, buildYear from housedeal where code = ? limit 1,8";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongcode);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HouseDealDTO houseDealDTO = new HouseDealDTO();
				houseDealDTO.setDong(rs.getString("dong"));
				houseDealDTO.setAptName(rs.getString("AptName"));
				houseDealDTO.setCode(rs.getString("code"));
				houseDealDTO.setDealAmount(rs.getString("dealAmount"));
				houseDealDTO.setBuildYear(rs.getInt("buildYear"));
			
				list.add(houseDealDTO);
			}
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return list;
	}

}
