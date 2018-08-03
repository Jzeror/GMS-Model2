package dao;

import java.util.List;

import domain.MemberBean;

public interface MemberDAO {
	public void insertMemId(MemberBean mm);
	public List<MemberBean> selectAllList();
	//public List<MemberBean> selectSomeList(String member);
	public MemberBean selectList(MemberBean member);
	public int countAccount();
	public void update(MemberBean member);
	public void delete(MemberBean member);
	public MemberBean login(MemberBean bean);
	public boolean selectOneList(MemberBean mm);
	public List<MemberBean> selectMemberBySearchWord(String word);
	
}
