package service;

import java.util.List;

import domain.SubjectBean;

public interface SubjectService {
	public void createScore(String word);
	public List<SubjectBean> showAllList();
	public List<SubjectBean> showSomeList(String word);
	public SubjectBean showOneList(String word);
	public int showCountList();
	public void modifySubject(String word);
	public void removeSubject(String word);
}
