package dao;

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
import service.ImageServiceImpl;
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
		map.put("member", mm);
		map.put("table", Domain.MEMBER);
		map.put("domain", "member");
		q.play(map);
	}
	@Override
	public MemberBean selectOne(String searchWord) {
		q = new RetrieveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("searchWord", searchWord);
		map.put("domain", "member");
		q.play(map);
		return (MemberBean)q.getO();
	}
	@Override
	public int count(Map<?,?> map) {
		q= new CountQuery();
		q.play(map);
		return (int)q.getNumber();
	}
	@Override
	public void update(Map<?,?> param) {
		q= new ModifyQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("columnMemId", "MEM_ID");		
		map.put("memId", param.get("memId"));
		String[] arr1 = {"PASSWORD","ROLL","TEAM_ID"};
		String[] arr2 = {
				param.get("pass").toString(),
				param.get("roll").toString(),
				param.get("teamId").toString()
			};
		for(int i=0 ; i<arr1.length ; i++) {
		map.put("column",arr1[i]);
		map.put("modi",arr2[i]);
		q.play(map);
		}
	}
	@Override
	public void delete(MemberBean member) {
		q =new RemoveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("memId", member.getMemId());
		map.put("pass", member.getPassword());
		map.put("domain", "member");
		ImageServiceImpl.getInstance().remove(member.getMemId());
		q.play(map);
	}
	@Override
	public MemberBean login(MemberBean bean) {
		q = new LoginQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId", bean.getMemId());
		map.put("pass", bean.getPassword());
		q.play(map);
		return (MemberBean)q.getO();
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
