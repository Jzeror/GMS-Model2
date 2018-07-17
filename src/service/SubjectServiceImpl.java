package service;

import java.util.List;

import domain.SubjectBean;

public class SubjectServiceImpl implements SubjectService{
	private static SubjectService instance = new SubjectServiceImpl();
	public static SubjectService getInstance() {
		return instance;
	}
	private SubjectServiceImpl() {}
	@Override
	public void createScore(String word) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<SubjectBean> showAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SubjectBean> showSomeList(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public SubjectBean showOneList(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int showCountList() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifySubject(String word) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeSubject(String word) {
		// TODO Auto-generated method stub
		
	}

		
}
