package template;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;

@Data
public abstract class QueryTemplate {
	int number;
	Object o;
	Map<String, Object>map;
	List<Object> list;
	PreparedStatement pstmt;
	public final void play(Map<?,?> param) {
		this.number = 0;
		this.o = null;
		this.pstmt = null;
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.UERNAME);
		this.map.put("password", DBConstant.PASSWORD);
		Iterator<?> keys = param.keySet().iterator();
		while(keys.hasNext()) {
			String key = (String) keys.next();
			this.map.put(key, param.get(key));
		}
		  initialize();
		  pstmtInit();
	      startPlay();
	      endPlay();
	}
	public final void play() {
		this.number = 0;
		this.o = null;
		this.pstmt = null;
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		this.map.put("vendor", Vendor.ORACLE);
		this.map.put("username", DBConstant.UERNAME);
		this.map.put("password", DBConstant.PASSWORD);
		  initialize();
		  pstmtInit();
	      startPlay();
	      endPlay();
	}
	public void pstmtInit() {
		try {
			this.pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String)map.get("sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
}
