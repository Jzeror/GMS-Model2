package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pool.DBConstant;

public class TestDAO {
	private static TestDAO instance = new TestDAO();

	public static TestDAO getInstance() {
		return instance;
	}
	private TestDAO() {}
public List<String> list() {	
	List<String> list = new ArrayList();

	try {
		Class.forName(DBConstant.ORACLE_DRIVER);
		Connection conn = DriverManager.getConnection(DBConstant.CONNECTION_URL,DBConstant.UERNAME,DBConstant.PASSWORD);
		Statement stmt = conn.createStatement();
		String sql = "SELECT AGE FROM MEMBER ";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			list.add(rs.getString("AGE"));
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}
}
