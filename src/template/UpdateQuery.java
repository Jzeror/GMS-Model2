package template;

import java.sql.SQLException;

import enums.MemberQuery;
import factory.DatabaseFactory;

public class UpdateQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", String.format(MemberQuery.UPDATE.toString(), map.get("table").toString(),map.get("column").toString())); 
	}

	@Override
	void startPlay() {
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement(map.get("spl").toString());
			pstmt.setString(1, map.get("searchTable").toString());
			pstmt.setString(2, map.get("updateWord").toString());
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
