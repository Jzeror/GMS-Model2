package template;

import domain.MemberBean;
import enums.MemberQuery;

public class RemoveQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", MemberQuery.DELETE.toString());
	}

	@Override
	void startPlay() {
		try {
			MemberBean mem = (MemberBean)map.get("member");
			pstmt.setString(1,mem.getMemId());
			pstmt.setString(2,mem.getPassword());
		} catch (Exception e) {e.printStackTrace();}
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
