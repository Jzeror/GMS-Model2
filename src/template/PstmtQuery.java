package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;
import lombok.Data;
@Data
public class PstmtQuery extends QueryTemplate {
	@Override
	void initialize() {
		if(map.get("column")!=null) {
		map.put("sql",
				String.format(" SELECT " + ColumnFinder.find(Domain.MEMBER) + " FROM %s " + " WHERE %s " + " LIKE ? ",
						map.get("table"), map.get("column")));
		}else {
			map.put("sql",
					String.format(" SELECT T.* FROM (SELECT ROWNUM SEQ, "+ ColumnFinder.find(Domain.MEMBER) + " FROM %s ORDER BY SEQ DESC) T	WHERE T.SEQ BETWEEN ? AND ? ",map.get("table")));
		}
	}
	
	@Override
	void startPlay() {
		/* String aa = "%"+map.get("value").toString()+"%"; */
		try {
			pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String) map.get("sql"));
			
			if(map.get("column")!=null) {
				pstmt.setString(1, "%" + map.get("value".toString()) + "%");
			}else {
				pstmt.setString(1,String.valueOf(map.get("beginRow".toString())));
				pstmt.setString(2,String.valueOf(map.get("endRow".toString())));
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
