package service;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberService {
	public void add(MemberBean mm);
	public List<MemberBean> search(Map<?,?> param);
	public MemberBean retrieve(String searchWord); //나중에 String id로 바꾸자 
	public int count(Map<?,?> map);
	public void modify(Map<?,?> param);
	public void remove(MemberBean member);
	
	public MemberBean login(MemberBean member);
	public void createR();
}
