package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.MemberBean;
import enums.MemberQuery;
import enums.Vendor;
import enums.DBConstant2;
import factory.DatabaseFactory;
import pool.DBConstant;
import service.MemberServiceImpl;

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
					.createStatement().executeUpdate(String.format(MemberQuery.INSERT_MEMBER.toString(), mm.getMemId(),
							mm.getName(), mm.getPassword(), mm.getSsn(), mm.getAge()));

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
				mem.setMemId(rs.getString("ADMINID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				lst.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public List<MemberBean> selectSomeList(String member) {
		List<MemberBean> lst = new ArrayList<>();
		try {
		ResultSet rs= DatabaseFactory
				.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD)
				.getConnection()
				.createStatement()
				.executeQuery(String.format(MemberQuery.SEARCHTEAM.toString(),member));
		 MemberBean temp = null; 
		 while(rs.next()) {
			 temp = new MemberBean();
			 temp.setTeamId(rs.getString("TEAM_ID"));
			 temp.setName(rs.getString("NAME"));
			 temp.setMemId(rs.getString("MEM_ID"));
			 temp.setAge(rs.getString("AGE"));
			 temp.setRoll(rs.getString("ROLL"));
			 lst.add(temp);
		 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	@Override
	public MemberBean selectList(MemberBean member) {
		MemberBean mem = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant2.UERNAME.toString(), DBConstant.PASSWORD).getConnection().createStatement().executeQuery(String.format(MemberQuery.SERCH_ID.toString(),member.getMemId()));
			while(rs.next()) {
			mem = new MemberBean();	
			mem.setAge(rs.getString("AGE"));
			mem.setMemId(rs.getString("MEM_ID"));
			mem.setName(rs.getString("NAME"));
			mem.setPassword(rs.getString("PASSWORD"));
			mem.setRoll(rs.getString("ROLL"));
			mem.setSsn(rs.getString("SSN"));
			mem.setTeamId(rs.getString("TEAM_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return mem;
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
							member.getPassword().split("/")[1], member.getPassword().split("/")[0], member.getMemId()));
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
				mem.setMemId(rs.getString("ADMINID"));
				mem.setAge(rs.getString("AGE"));
				mem.setName(rs.getString("NAME"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setSsn(rs.getString("SSN"));
				mem.setTeamId(rs.getString("TEAMID"));
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
}
