package com.happyhouse.model.DAO;

import java.sql.SQLException;

import com.happyhouse.model.DTO.MemberDTO;

public interface MemberDAO {
	
	//로그인
	public MemberDTO login(String userid, String userpwd) throws SQLException;
	
	
	//회원가입
	public int insert(MemberDTO memberDTO) throws SQLException;
	
	
	//회원삭제 => cascade issue 있을 수도
	public int delete(String id) throws SQLException;
	
	
	//회원정보수정 => 그냥 삭제하고 다시 가입으로 처리해버리기.. => 이방식으로 해버리면 연결되버린 관심정보들이 다 사라져 버림 cascade때문에, 그냥 update 사용하자....
	public int update(MemberDTO memberDTO) throws SQLException;
	
	
}	
