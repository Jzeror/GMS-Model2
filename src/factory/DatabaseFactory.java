package factory;


import java.util.Map;

import enums.Vendor;
import pool.DBConstant;

public class DatabaseFactory {
	public static Database createDatabase(
			Vendor v, String id, String pass) {
		Database db = null;
		String driver = "", url = "";
		switch (v) {
		case ORACLE:
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver,url,id, pass);
			break;
		case MYSQL:
			driver = DBConstant.MYSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MySQL(driver,url,id, pass);
			break;
		case MARIADB:
			driver = DBConstant.MARIADB_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MariaDB(driver,url,id, pass);
			break;
		case MSSQL:
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MsSQL(DBConstant.MSSQL_DRIVER,url,id, pass);
			break;
		}
		return db;
	}
	
	public static Database createDatabase2(
			Map<String, Object> map) {
		Database db = null;
		String driver = "", url = "";
		switch ((Vendor)map.get("vendor")) {
		case ORACLE:
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new Oracle(driver,url,
					(String)map.get("username"),
					(String)map.get("password")
					);
			break;
		case MYSQL:
			driver = DBConstant.MYSQL_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MySQL(driver,url,
					(String)map.get("username"),
					(String)map.get("password")
					);
			break;
		case MARIADB:
			driver = DBConstant.MARIADB_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MariaDB(driver,url,
					(String)map.get("username"),
					(String)map.get("password")
					);
			break;
		case MSSQL:
			driver = DBConstant.ORACLE_DRIVER;
			url = DBConstant.CONNECTION_URL;
			db = new MsSQL(DBConstant.MSSQL_DRIVER,url,
					(String)map.get("username"),
					(String)map.get("password")
					);
			break;
		}
		return db;
	}
}
