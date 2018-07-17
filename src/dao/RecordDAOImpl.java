package dao;

import java.util.List;

import domain.RecordBean;


public class RecordDAOImpl implements RecordDAO {
	private static RecordDAO instance = new RecordDAOImpl();
	public static RecordDAO getInstance() {
		return instance;
	}
	private RecordDAOImpl() {}
	@Override
	public void insertRecord(RecordBean exam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RecordBean> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordBean> selectSomeList(String record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordBean selectOneList(String record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(RecordBean record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(RecordBean record) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String selectFirstRowNum() {
		// TODO Auto-generated method stub
		return null;
	}

}
