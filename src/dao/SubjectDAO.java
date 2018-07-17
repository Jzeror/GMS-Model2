package dao;

import java.util.List;

import domain.SubjectBean;

public interface SubjectDAO {
	public void insertScore(SubjectBean subject);
	public List<SubjectBean> selectList();
	public List<SubjectBean> selectSomeList(String subject);
	public SubjectBean selectOneList(String subject);
	public int countAccount();
	public void update(SubjectBean subject);
	public void delete(SubjectBean subject);
}
