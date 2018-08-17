package template;

import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class ModifyQuery extends QueryTemplate {
	@Override
	void initialize() {
		map.put("sql", String.format(MemberQuery.UPDATE.toString(),
				map.get("column").toString(),map.get("columnMemId").toString())); 
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, map.get("modi").toString());
			pstmt.setString(2, map.get("memId").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
