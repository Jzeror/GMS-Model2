package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.ImageQuery;
import enums.MemberQuery;

public class AddQuery extends QueryTemplate {
	@Override
	void initialize() {
		switch(map.get("domain").toString()) {
		case "member" : 
			map.put("sql", MemberQuery.INSERT.toString());
			break;
		case "image" :
			map.put("sql", ImageQuery.INSERT.toString());
			break;
		}
		
	}
	@Override
	void startPlay() {
		try {
			switch(map.get("domain").toString()) {
			case "member" : 
				MemberBean mem=(MemberBean)map.get("member");
				pstmt.setString(1, mem.getMemId() );
				pstmt.setString(2, mem.getName());
				pstmt.setString(3, mem.getPassword());
				pstmt.setString(4, mem.getSsn());
				pstmt.setString(5, mem.getAge());
				pstmt.setString(6, mem.getGender());
				pstmt.setString(7, mem.getRoll());
				pstmt.setString(8, mem.getTeamId());
				break;
			case "image" : 
				pstmt.setString(1, map.get("imgName").toString() );
				pstmt.setString(2, map.get("extension").toString() );
				pstmt.setString(3, map.get("memId").toString() );
		
				break;
			}
			
		
		
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
