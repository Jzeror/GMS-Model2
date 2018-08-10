package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class LoginQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.LOGIN.toString());
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1,map.get("userId").toString());
			pstmt.setString(2, map.get("pass").toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
			while(rs.next()) {
				mem = new MemberBean();
				mem.setMemId(rs.getString("MEM_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
				o=mem;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
