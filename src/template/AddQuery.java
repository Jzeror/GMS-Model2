package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class AddQuery extends QueryTemplate {
	@Override
	void initialize() {
		map.put("sql", MemberQuery.INSERT.toString());
	}
	@Override
	void startPlay() {
		try {
			MemberBean mem=(MemberBean)map.get("member");
			pstmt.setString(1, mem.getMemId() );
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setString(4, mem.getSsn());
			pstmt.setString(5, mem.getAge());
			pstmt.setString(6, mem.getGender());
			pstmt.setString(7, mem.getRoll());
			pstmt.setString(8, mem.getTeamId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
