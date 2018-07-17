package dao;

import java.util.List;

import domain.ExamBean;


public interface ExamDAO {
	public void insertScore(ExamBean exam);
	public List<ExamBean> selectList();
	public List<ExamBean> selectSomeList(String exam);
	public ExamBean selectOneList(String exam);
	public int countAccount();
	public void update(ExamBean exam);
	public void delete(ExamBean exam);
}
