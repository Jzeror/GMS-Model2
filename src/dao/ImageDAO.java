package dao;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageDAO {
	public void insert(Map<?,?> map);
	public List<ImageBean> selectSome(String word);
	public ImageBean selectOne(String id);
	public int count();
	public void update(ImageBean img);
	public void delete(String word);
}
