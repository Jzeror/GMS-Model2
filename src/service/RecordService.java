package service;

import java.util.List;

import domain.RecordBean;

public interface RecordService {
	public void createScore(String word);
	public List<RecordBean> showAllList();
	public List<RecordBean> showSomeList(String word);
	public RecordBean showOneList(String word);
	public int showCountList();
	public void modifyRecord(String word);
	public void removeRecord(String word);
}
