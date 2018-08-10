package template;

import java.sql.SQLException;

import enums.MemberQuery;

public class AddQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", MemberQuery.INSERT.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String)map.get("memId"));
			pstmt.setString(2, (String)map.get("name"));
			pstmt.setString(3, (String)map.get("password"));
			pstmt.setString(4, (String)map.get("ssn"));
			pstmt.setString(5, (String)map.get("age"));
			pstmt.setString(6, (String)map.get("gender"));
			pstmt.setString(7, (String)map.get("roll"));
			pstmt.setString(8, (String)map.get("teamId"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	void endPlay() {}

}
