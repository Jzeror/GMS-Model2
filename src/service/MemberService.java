package service;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberService {
	public void createMemId(MemberBean mm);
	public void createR();
	public List<MemberBean> showAllList();
	public List<MemberBean> showAllList55555(Map<?,?> param);

	public List<MemberBean> showSomeList(String word);

	public MemberBean showList(MemberBean member);
	public boolean showOneList(MemberBean mm);

	public int showCountList();

	public void modifyMember(MemberBean member);

	public void removeMember(MemberBean member);
	
	public MemberBean login(MemberBean member);
	
/*	public String createAge(MemberBean mm);*/
}
