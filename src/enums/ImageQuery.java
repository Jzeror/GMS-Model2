package enums;

import template.ColumnFinder;

public enum ImageQuery {
	INSERT,
	LIST, SEARCH, RETRIEVE, COUNT, COUNTSEARCH,
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
			query = " INSERT INTO IMAGE (IMG_SEQ, IMGNAME, EXTENSION, MEM_ID) VALUES (IMG_SEQ.NEXTVAL, ?, ?, ?) ";
			break;
		case CONFIRM_ID:
			query = " SELECT MEM_ID  " + " FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'   ";
			break;
		case COUNT:
			query = "SELECT COUNT(*) AS count FROM MEMBER";
			break;
		case COUNTSEARCH:
			query = "SELECT COUNT(*) AS count FROM MEMBER WHERE %s LIKE ? ";
			break;
		case UPDATE:
			query = "UPDATE MEMBER SET %s = ?  WHERE %s LIKE ? ";
			break;
		case DELETE:
			query = "DELETE FROM IMAGE WHERE MEM_ID LIKE ? ";
			break;
		case LIST:
			query = " SELECT T.* FROM (SELECT ROWNUM SEQ, "+ ColumnFinder.find(Domain.MEMBER) + " FROM MEMBER ORDER BY SEQ DESC) T	WHERE T.SEQ BETWEEN ? AND ? ";
			break;
		case RETRIEVE:
			query = " SELECT IMGNAME, EXTENSION, MEM_ID FROM IMAGE WHERE MEM_ID  LIKE ? ";
			break;
		case SEARCH:
			query = " SELECT T.* FROM (SELECT ROWNUM SEQ, "+ ColumnFinder.find(Domain.MEMBER) + " FROM MEMBER WHERE %s LIKE '%s' ORDER BY SEQ DESC) T	WHERE T.SEQ BETWEEN ? AND ? ";
			break;
		}
		return query;
	}
}
