package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",MemberQuery.COUNT.toString());
	}
	@Override
	void startPlay() {}
	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			number = rs.getInt("count");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
