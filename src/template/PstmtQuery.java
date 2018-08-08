package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;
import lombok.Data;
@Data
public class PstmtQuery extends QueryTemplate {
	@Override
	void initialize() {
		
		switch ((String)map.get("confirm")) {
		case "selectSome":
			map.put("sql",
					String.format(MemberQuery.SELECT_SOME.toString(),map.get("table")));
			break;
		case "selectMemberBySearchWord":
			map.put("sql",
					String.format(MemberQuery.SELECT_MEMBER_BY_SEARCHWORD.toString(), map.get("table"), map.get("column")));
			break;
		case "insert":
			map.put("sql", MemberQuery.INSERT_MEMBER.toString() );
			break;
		case "selectOne":
			map.put("sql",MemberQuery.SERCH_ID.toString() );
			break;
		
		}
		
	}
	
	@Override
	void startPlay() {
		/* String aa = "%"+map.get("value").toString()+"%"; */
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String) map.get("sql"));
			
			switch ((String)map.get("confirm")) {
			case "selectSome":
				pstmt.setString(1,String.valueOf(map.get("beginRow".toString())));
				pstmt.setString(2,String.valueOf(map.get("endRow".toString())));
				break;
			case "selectMemberBySearchWord":
				pstmt.setString(1, "%" + map.get("value".toString()) + "%");
				break;
			case "insert":
				//MEM_ID, NAME, PASSWORD, SSN, AGE, GENDER, ROLL, TEAM_ID
				pstmt.setString(1, (String)map.get("memId"));
				pstmt.setString(2, (String)map.get("name"));
				pstmt.setString(3, (String)map.get("password"));
				pstmt.setString(4, (String)map.get("ssn"));
				pstmt.setString(5, (String)map.get("age"));
				pstmt.setString(6, (String)map.get("gender"));
				pstmt.setString(7, (String)map.get("roll"));
				pstmt.setString(8, (String)map.get("teamId"));
				break;
			case "selectOne":
				pstmt.setString(1, (String)map.get("searchWord"));
				break;
			}
			
			
		} catch (Exception e) {
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
					list.add(mem); //list는 조상에 있는 list
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
