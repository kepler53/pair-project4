package com.happyhouse.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.happyhouse.model.DTO.MemberDTO;
import com.happyhouse.util.DBUtil;


public class MemberDAOImpl implements MemberDAO {

	@Override
	public MemberDTO login(String userid, String userpwd) throws SQLException {
		MemberDTO memberDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select userid, useremail \n");
			sql.append("from MEMBER_TB \n");
			sql.append("where userid = ? and userpwd = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userid);
			pstmt.setString(2, userpwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDTO();
				memberDto.setUserid(rs.getString("userid"));
				memberDto.setUserpwd(userpwd);
				memberDto.setUseremail(rs.getString("useremail"));
				
			}
		} catch (SQLException e) {
			System.out.println("memeber login error");
			e.printStackTrace();
			memberDto = null;
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}
		return memberDto;
	}

	@Override
	public int insert(MemberDTO memberDTO) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO MEMBER_TB(USERID,USERPWD,USEREMAIL) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getUserid());
			pstmt.setString(2, memberDTO.getUserpwd());
			pstmt.setString(3, memberDTO.getUseremail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member dao insert error");
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}

	@Override
	public int delete(String id) throws SQLException {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			System.out.println("id는" +id);
			String sql = "DELETE FROM MEMBER_TB WHERE USERID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member dao delete error");
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}

	@Override
	public int update(MemberDTO memberDTO) throws SQLException {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE MEMBER_TB SET USERPWD=?,USEREMAIL =? WHERE USERID = ?";
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getUserpwd());
			pstmt.setString(2, memberDTO.getUseremail());
			pstmt.setString(3, memberDTO.getUserid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("member dao update error");
		} finally {
			DBUtil.close(pstmt, conn);
		}
		return result;
	}

	

	
	
}
