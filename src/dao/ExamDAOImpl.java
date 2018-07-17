package dao;

import java.util.List;

import domain.ExamBean;

public class ExamDAOImpl implements ExamDAO {
	private static ExamDAO instance = new ExamDAOImpl();
	public static ExamDAO getInstance() {
		return instance;
	}
	private ExamDAOImpl() {}
	@Override
	public void insertScore(ExamBean exam) {
		
		
	}

	@Override
	public List<ExamBean> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExamBean> selectSomeList(String exam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamBean selectOneList(String exam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ExamBean exam) {
		// TODO Auto-generated method stub
		
	}

}
