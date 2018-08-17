package template;

import java.sql.PreparedStatement;

import domain.MemberBean;
import enums.ImageQuery;
import enums.MemberQuery;
import factory.DatabaseFactory;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RemoveQuery extends QueryTemplate {
	PreparedStatement pstmt2;
	@Override
	void initialize() {
		switch(map.get("domain").toString()) {
		case "member" : 
			map.put("sql", MemberQuery.DELETE.toString());
			break;
		case "image" :
			map.put("sql", ImageQuery.DELETE.toString());
			break;
		}
	}

	@Override
	void startPlay() {
		try {
			switch(map.get("domain").toString()) {
			case "member" : 
				pstmt.setString(1,map.get("memId").toString());
				pstmt.setString(2,map.get("pass").toString());
				break;
			case "image" :
				pstmt.setString(1,map.get("memId").toString());
				break;
			}
		} catch (Exception e) {e.printStackTrace();}
	}

	@Override
	void endPlay() {
		try {
			switch(map.get("domain").toString()) {
			case "member" : 
				pstmt.executeUpdate();
				break;
			case "image" :
				pstmt.executeUpdate();
				break;
			}
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
