package dao;

import java.util.List;

import domain.SubjectBean;

public class SubjectDAOImpl implements SubjectDAO{
	private static SubjectDAO instance = new SubjectDAOImpl();
	public static SubjectDAO getInstance() {
		return instance;
	}
	private SubjectDAOImpl() {}
	@Override
	public void insertScore(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SubjectBean> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectBean> selectSomeList(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectBean selectOneList(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SubjectBean subject) {
		// TODO Auto-generated method stub
		
	}

}
