package com.happyhouse.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String ID = "leejh";
	private static final String PASSWORD = "dydak5310!";
	
	//이부분 각자에 맞게 바꾸기
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PASSWORD);
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable ac : closeables) {
			if (ac != null)
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}

