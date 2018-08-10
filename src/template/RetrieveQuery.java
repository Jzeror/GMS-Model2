package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",String.format(MemberQuery.RETRIEVE.toString(),map.get("table")));
	}
	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String)map.get("searchWord"));
		} catch (Exception e) {e.printStackTrace();}
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
				o=mem; //list는 조상에 있는 list
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
