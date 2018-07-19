package enums;

public enum DBConstant2 {
	ORACLE_DRIVER,CONNECTION_URL,UERNAME,PASSWORD;
	@Override
	public String toString() {
		String s ="";
		switch(this) {
		case ORACLE_DRIVER: 
			s="oracle.jdbc.driver.OracleDriver" ;
			break;
		case CONNECTION_URL:
			s="jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case UERNAME:
			s="jzero";
			break;
		case PASSWORD:
			s="fbworud0";
			break;
		
		}
		return s;
	}
}
