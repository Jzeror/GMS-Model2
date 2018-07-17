package dao;

import java.util.List;

import domain.RecordBean;

public interface RecordDAO {
	public void insertRecord(RecordBean exam);
	public List<RecordBean> selectList();
	public List<RecordBean> selectSomeList(String record);
	public RecordBean selectOneList(String record);
	public int countAccount();
	public void update(RecordBean record);
	public void delete(RecordBean record);
	public String selectFirstRowNum();
}
