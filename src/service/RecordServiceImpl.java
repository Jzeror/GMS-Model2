package service;

import java.util.List;

import domain.RecordBean;

public class RecordServiceImpl implements RecordService {
	private static RecordService instance = new RecordServiceImpl();
	public static RecordService getInstance() {
		return instance;
	}
	private RecordServiceImpl() {}
	@Override
	public void createScore(String word) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<RecordBean> showAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<RecordBean> showSomeList(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public RecordBean showOneList(String word) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int showCountList() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void modifyRecord(String word) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeRecord(String word) {
		// TODO Auto-generated method stub
		
	}
}
