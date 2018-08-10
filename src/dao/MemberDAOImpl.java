package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import enums.MemberQuery;
import enums.Vendor;
import enums.DBConstant2;
import enums.Domain;
import factory.DatabaseFactory;
import pool.DBConstant;
import template.*;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAOImpl() {
	}
	private QueryTemplate q;
	@Override
	public void insert(MemberBean mm) {
		q =new AddQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		q.play(map);
	}
	@Override
	public MemberBean selectOne(String searchWord) {
		q = new RetrieveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("searchWord", searchWord);
		q.play(map);
		return (MemberBean)q.getO();
	}
	@Override
	public int count() {
		q= new CountQuery();
		HashMap<String, Object> map = new HashMap<>();
		q.play();
		return (int)q.getNumber();
	}
	@Override
	public void update(Map<?,?> param) {
		q= new ModifyQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);			//얘네는 나중에 
		map.put("searchTable", Domain.MEMBER);		//동적으로 만들자.
		map.put("column", "MEM_ID");		
		map.put("updateWord", param.get("updateWord"));
		q.play(map);

	}
	@Override
	public void delete(MemberBean member) {
		
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD).getConnection()
					.createStatement().executeUpdate(
							String.format(MemberQuery.DELETE.toString(), member.getPassword(), member.getMemId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public MemberBean login(MemberBean bean) {
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD)
					.getConnection().createStatement()
					.executeQuery(String.format(MemberQuery.LOGIN.toString(), bean.getMemId(), bean.getPassword()));
			if (rs.next()) {
				mem = new MemberBean();
				mem.setMemId(rs.getString("MEM_ID"));
				mem.setAge(rs.getString("AGE"));
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setGender(rs.getString("GENDER"));
			} else {
				mem = new MemberBean();
				mem.setAge("999");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mem;
	}

	@Override
	public List<MemberBean> selectSome(Map<?,?> param) {
		List<MemberBean> list = new ArrayList<>();
		q= new SearchQuery();
		q.play(param);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}
}
