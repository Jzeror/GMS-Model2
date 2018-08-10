package dao;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberDAO {
	public void insert(MemberBean mm);
	public List<MemberBean> selectSome(Map<?,?> param);
	public MemberBean selectOne(String searchWord);
	public int count();
	public void update(Map<?,?> param);
	public void delete(MemberBean member);
	
	public MemberBean login(MemberBean bean);
	
}
