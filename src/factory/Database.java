package factory;

import java.sql.Connection;

public interface Database {
	public Connection getConnection();
}
