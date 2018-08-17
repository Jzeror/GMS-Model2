package service;

import java.util.List;
import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void add(Map<?,?> map);
	public List<ImageBean> search(String word);
	public ImageBean retrieve(String id);
	public int count();
	public void modify(ImageBean img);
	public void remove(String word);
}
