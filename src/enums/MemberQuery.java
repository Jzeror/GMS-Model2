package enums;

import template.ColumnFinder;

public enum MemberQuery {
	INSERT,
	LIST, SEARCH, RETRIEVE, COUNT,
	UPDATE,
	DELETE,
	LOGIN,	
	CONFIRM_ID  ;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case LOGIN:
			query = " SELECT "+ColumnFinder.find(Domain.MEMBER) + " FROM MEMBER " + " WHERE MEM_ID LIKE  ?  AND  PASSWORD  LIKE  ? ";
			break;
		case INSERT:
			query = " INSERT INTO MEMBER (MEM_ID, NAME, PASSWORD, SSN, AGE, GENDER, ROLL, TEAM_ID) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? ) ";
			break;
		case CONFIRM_ID:
			query = " SELECT MEM_ID  " + " FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'   ";
			break;
		case COUNT:
			query = "SELECT COUNT(*) AS count FROM MEMBER";
			break;
		case UPDATE:
			query = "UPDATE MEMBER SET %s = ?  WHERE %s LIKE ? ";
			break;
		case DELETE:
			query = "DELETE FROM MEMBER WHERE PASSWORD LIKE ? AND MEM_ID LIKE ? ";
			break;
		case LIST:
			query = " SELECT MEM_ID  , " + " TEAM_ID  ," + " NAME , " + " AGE ," + " ROLL , "
					+ " PASSWORD, " + " SSN , GENDER " + " FROM MEMBER "+" WHERE T.SEQ BETWEEN ? AND ? ";
			break;

		case RETRIEVE:
			query = " SELECT " + ColumnFinder.find(Domain.MEMBER) + " FROM %s " + " WHERE MEM_ID " + " LIKE ? ";
			break;
		case SEARCH:
			query = " SELECT T.* FROM (SELECT ROWNUM SEQ, "+ ColumnFinder.find(Domain.MEMBER) + " FROM %s ORDER BY SEQ DESC) T	WHERE T.SEQ BETWEEN ? AND ? ";
			break;
		}

		return query;
	}
}
