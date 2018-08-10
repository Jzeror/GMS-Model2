package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class SearchQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", (!map.containsKey("searchOption"))? MemberQuery.LIST.toString()
				: String.format(MemberQuery.SEARCH.toString(),map.get("searchOption"),map.get("searchWord")));
	}

	@Override
	void startPlay() {
		try {
			pstmt.setString(1, map.get("beginRow").toString());
			pstmt.setString(2, map.get("endRow").toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
				list.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
