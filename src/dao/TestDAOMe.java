package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;

public class TestDAOMe {

		private static TestDAOMe instance = new TestDAOMe();

		public static TestDAOMe getInstance() {
			return instance;
		}
		private TestDAOMe() {}
	public List<String> list() {	
		List<String> list = new ArrayList();
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jzero","fbworud0");
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
