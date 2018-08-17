package service;

import java.util.List;
import java.util.Map;

import dao.ImageDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService {
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}
	@Override
	public void add(Map<?,?> map) {
		ImageDAOImpl.getInstance().insert(map);
	}

	@Override
	public List<ImageBean> search(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageBean retrieve(String id) {
		// TODO Auto-generated method stub
		return ImageDAOImpl.getInstance().selectOne(id);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modify(ImageBean img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(String word) {
		ImageDAOImpl.getInstance().delete(word);
		
	}

}
