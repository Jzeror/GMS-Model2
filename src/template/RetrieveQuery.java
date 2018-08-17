package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch (map.get("domain").toString()) {
		case "member":
			map.put("sql", String.format(MemberQuery.RETRIEVE.toString(), map.get("table")));
			break;
		case "image":
			map.put("sql", ImageQuery.RETRIEVE.toString());
			break;
		}

	}

	@Override
	void startPlay() {

		try {
			switch (map.get("domain").toString()) {
			case "member":
				pstmt.setString(1, (String)map.get("searchWord"));
				break;
			case "image":
				pstmt.setString(1, map.get("id").toString());
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	void endPlay() {

		try {
			ResultSet rs = pstmt.executeQuery();
			switch (map.get("domain").toString()) {
			case "member":
				MemberBean mem = null;
				while (rs.next()) {
					mem = new MemberBean();
					mem.setMemId(rs.getString("MEM_ID"));
					mem.setTeamId(rs.getString("TEAM_ID"));
					mem.setName(rs.getString("NAME"));
					mem.setAge(rs.getString("AGE"));
					mem.setRoll(rs.getString("ROLL"));
					mem.setPassword(rs.getString("PASSWORD"));
					mem.setSsn(rs.getString("SSN"));
					mem.setGender(rs.getString("GENDER"));
					o = mem;
				}
				break;
			case "image":
				ImageBean img = null;
				while(rs.next()) {
					img= new ImageBean();
					img.setImgName(rs.getString("IMGNAME"));
					img.setExtension(rs.getString("EXTENSION"));
					img.setMemId(rs.getString("MEM_ID"));
					o=img;
				}
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
