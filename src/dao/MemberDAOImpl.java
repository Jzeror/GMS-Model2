package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import domain.MemberBean;
import enums.MemberQuery;
import enums.Vendor;
import enums.DBConstant2;
import enums.Domain;
import factory.DatabaseFactory;
import pool.DBConstant;
import template.PstmtQuery;
import template.QueryTemplate;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();

	public static MemberDAO getInstance() {
		return instance;
	}

	private MemberDAOImpl() {
	}

	@Override
	public void insertMemId(MemberBean mm) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString().toString(), DBConstant.PASSWORD).getConnection()
					.createStatement().executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(),
							mm.getMemId(),	mm.getName(), mm.getPassword(), mm.getSsn(), mm.getAge(), mm.getGender(), mm.getRoll(), mm.getTeamId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAllList() {
		List<MemberBean> lst = new ArrayList<>();
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(MemberQuery.SELECT_ALL.toString());
			MemberBean mem = null;
			while (rs.next()) {
				mem = new MemberBean();
				mem.setMemId(rs.getString("MEM_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
				lst.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
  
/*	@Override
	public List<MemberBean> selectSomeList(String member) {
		List<MemberBean> lst = new ArrayList<>();
		System.out.println(member.split("/")[0].toUpperCase());
		System.out.println(member.split("/")[1].toUpperCase());
		try {		
		ResultSet rs= DatabaseFactory
				.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD)
				.getConnection()
				.createStatement()
				.executeQuery(" SELECT MEM_ID , TEAM_ID , NAME , AGE , ROLL , PASSWORD , SSN , GENDER FROM MEMBER WHERE "+member.split("/")[0].toUpperCase()+" LIKE '%"+member.split("/")[1]+"%'");
		 MemberBean mem = null; 
		 while(rs.next()) {
				mem = new MemberBean();
				mem.setMemId(rs.getString("MEM_ID"));
				mem.setTeamId(rs.getString("TEAM_ID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				mem.setGender(rs.getString("GENDER"));
			 lst.add(mem);
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(lst);
		return lst;
	}*/
	@Override
	public MemberBean selectList(MemberBean member) {

		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD).getConnection().createStatement().executeQuery(String.format(MemberQuery.SERCH_ID.toString(),member.getMemId()));
			while(rs.next()) {
				member.setMemId(rs.getString("MEM_ID"));
				member.setAge(rs.getString("AGE"));
				member.setName(rs.getString("NAME"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				member.setTeamId(rs.getString("TEAM_ID"));
				member.setGender(rs.getString("GENDER"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public int countAccount() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD)
					.getConnection().createStatement().executeQuery(MemberQuery.COUNT_MEMBER.toString());

			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void update(MemberBean member) {

		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD).getConnection()
					.createStatement().executeUpdate(String.format(MemberQuery.UPDATE.toString(),
							member.getPassword(), member.getTeamId(), member.getRoll() , member.getMemId()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
	public boolean selectOneList(MemberBean mm) {
		boolean flag = true;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD)
					.getConnection().createStatement()
					.executeQuery(String.format(MemberQuery.CONFIRM_ID.toString(), mm.getMemId()));
			while (rs.next()) {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
/*		if (flag == true) {
			MemberServiceImpl.getInstance().createAge(mm);
		}*/
		return flag;

	}
	
	public List<MemberBean> selectMemberBySearchWord(String word){
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("column", word.split("/")[0]);
		map.put("value", word.split("/")[1]);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
		}
		return list;
	}
	
}
