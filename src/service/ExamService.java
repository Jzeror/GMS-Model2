package service;

import java.util.List;

import domain.ExamBean;

public interface ExamService {
	public void createScore(ExamBean bean);
	public List<ExamBean> showAllList();
	public List<ExamBean> showSomeList(String exam);
	public ExamBean showOneList(String exam);
	public int countList();
	public void modifyExam(String exam);
	public void removeExam(String exam);
}
