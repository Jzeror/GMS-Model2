package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class CountQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",(map.get("searchWord").toString().equals("none"))?
				MemberQuery.COUNT.toString():
					String.format(MemberQuery.COUNTSEARCH.toString(), map.get("searchOption"))
				);
	}
	@Override
	void startPlay() {
		try {
			if(!map.get("searchWord").toString().equals("none")) {
				pstmt.setString(1, map.get("searchWord").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			number = rs.getInt("count");
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

}
