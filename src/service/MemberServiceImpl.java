package service;

import java.util.List;
import java.util.Map;
import java.util.Random;


import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {
		return instance;
	}
	private MemberServiceImpl() {}
	@Override
	public void add(MemberBean mm) {
		MemberDAOImpl.getInstance().insert(mm);
	}
	@Override
	public int count(Map<?,?> map) {
		return MemberDAOImpl.getInstance().count(map);
	}
	@Override
	public void modify(Map<?,?> param) {
		MemberDAOImpl.getInstance().update(param);
		
	}
	@Override
	public void remove(MemberBean member) {
		MemberDAOImpl.getInstance().delete(member);
		
	}
	@Override
	public MemberBean login(MemberBean member) {
		return MemberDAOImpl.getInstance().login(member);
	}
	@Override
	public MemberBean retrieve(String searchWord) {
		return MemberDAOImpl.getInstance().selectOne(searchWord);
	}
	@Override
	public List<MemberBean> search(Map<?,?> param) {
		return MemberDAOImpl.getInstance().selectSome(param);
	}
	@Override
	public void createR() {
		for(int e=0 ; e<10 ; e++ ) {
		String w ="";
		switch((int)(Math.random()*13+1)) {
		case 1: w="김"; break;
		case 2: w="김"; break;
		case 3: w="박"; break;
		case 4: w="이"; break;
		case 5: w="최"; break;
		case 6: w="정"; break;
		case 7: w="류"; break;
		case 8: w="신"; break;
		case 9: w="이"; break;
		case 10: w="김"; break;
		case 11: w="성"; break;
		case 12: w="이"; break;
		case 13: w="김"; break;
		}
		String w2 ="";
		switch((int)(Math.random()*9+1)) {
		case 1: w2="정"; break;
		case 2: w2="순"; break;
		case 3: w2="진"; break;
		case 4: w2="윤"; break;
		case 5: w2="현"; break;
		case 6: w2="재"; break;
		case 7: w2="정"; break;
		case 8: w2="지"; break;
		case 9: w2="수"; break;
		}
		String w3 ="";
		switch((int)(Math.random()*9+1)) {
		case 1: w3="필"; break;
		case 2: w3="청"; break;
		case 3: w3="영"; break;
		case 4: w3="형"; break;
		case 5: w3="주"; break;
		case 6: w3="신"; break;
		case 7: w3="성"; break;
		case 8: w3="희"; break;
		case 9: w3="호"; break;
		}
		String name = w+w2+w3;
		
		Random rnd = new Random();
		String i1 = String.valueOf((char) ((int) (rnd.nextInt(26)) + 65));
		
		String i2="";
		for(int s = 0 ; s<4 ; s++) {
		i2 += String.valueOf((char) ((int) (rnd.nextInt(26)) + 97));
		}
		String i3="";
		for(int s = 0 ; s<3 ; s++) {
			i3 += (int) (Math.random()*10);
			}
		String id = i1+i2+i3;
		String pass="";
		for(int s = 0 ; s<6 ; s++) {
			pass += (int) (Math.random()*10);
			}
		int a = 0, c = 0, b=0;
		String  d="";
			for (int s = 0; s < 10; s++) {
				b= (int) ((Math.random() * 10) + 85);
				a = (int) ((Math.random() * 12) + 1);
				c = (int) ((Math.random() * 30) + 1);
				d = String.valueOf((int) ((Math.random() * 2) + 1));
			}
			String ssn = String.format("%02d", b)
							+ String.format("%02d", a) 
							+ String.format("%02d", c)
							+"-"+d;
		String gen="여자";
		if(Integer.valueOf(d)==1) {
			gen="남자";
		}
		int age=119-b;
		String teamid="";
		switch((int)((Math.random()*4)+1)) {
		case 1: teamid="A"; break;
		case 2: teamid="B"; break;
		case 3: teamid="C"; break;
		case 4: teamid="D"; break;
		}
		String roll="";
		switch((int)((Math.random()*4)+1)) {
		case 1: roll="front"; break;
		case 2: roll="back"; break;
		case 3: roll="android"; break;
		case 4: roll="cheerLeader"; break;
		}
		MemberBean mem = new MemberBean();
		mem.setAge(String.valueOf(age));
		mem.setGender(gen);
		mem.setMemId(id);
		mem.setName(name);
		mem.setPassword(pass);
		mem.setRoll(roll);
		mem.setSsn(ssn);
		mem.setTeamId(teamid);
		
		MemberDAOImpl.getInstance().insert(mem);
		}
			//
	}
}



/**
	public boolean login(MemberBean member) {
	
		return (MemberDAOImpl.getInstance().login(member)!=null);
	}
 * */
 