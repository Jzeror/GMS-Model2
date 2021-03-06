package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER, CONFIRM_ID, COUNT_MEMBER, UPDATE, DELETE, SELECT_ALL, SEARCHTEAM, SERCH_ID, ;
	@Override
	public String toString() {
		String query = "";
		switch (this) {
		case LOGIN:
			query = " SELECT MEM_ID  , " + " TEAM_ID  ," + " NAME , " + " AGE ," + " ROLL , "
					+ " PASSWORD, SSN, GENDER " + " FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'  AND  PASSWORD  LIKE  '%s' ";
			break;
		case INSERT_MEMBER:
			query = " INSERT INTO MEMBER (MEM_ID, NAME, PASSWORD, SSN, AGE, GENDER, ROLL, TEAM_ID) VALUES ( '%s', '%s', '%s' , '%s' , '%s', '%s', '%s', '%s') ";
			break;
		case CONFIRM_ID:
			query = " SELECT MEM_ID  " + " FROM MEMBER " + " WHERE MEM_ID LIKE  '%s'   ";
			break;
		case COUNT_MEMBER:
			query = "SELECT COUNT(*) AS count FROM MEMBER";
			break;
		case UPDATE:
			query = "UPDATE MEMBER SET PASSWORD = '%s' , TEAM_ID = '%s' , ROLL = '%s' " + " WHERE MEM_ID LIKE '%s' ";
			break;
		case DELETE:
			query = "DELETE FROM MEMBER WHERE PASSWORD LIKE '%s' AND MEM_ID LIKE '%s' ";
			break;
		case SELECT_ALL:
			query = " SELECT MEM_ID  , " + " TEAM_ID  ," + " NAME , " + " AGE ," + " ROLL , "
					+ " PASSWORD, " + " SSN , GENDER " + " FROM MEMBER ";
			break;
		case SEARCHTEAM:
			query = " SELECT MEM_ID  , " + " TEAM_ID  ," + " NAME , " + " AGE ," + " ROLL , "
					+ " PASSWORD, " + " SSN , GENDER " + " FROM MEMBER   WHERE %s LIKE '%s' ";
			break;
		case SERCH_ID:
			query = " SELECT MEM_ID, NAME, PASSWORD, SSN, AGE, GENDER, ROLL, GENDER , TEAM_ID FROM MEMBER WHERE MEM_ID LIKE '%s' ";
			break;
		}

		return query;
	}
}
