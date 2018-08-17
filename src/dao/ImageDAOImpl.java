package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.ImageBean;
import enums.Domain;
import template.AddQuery;
import template.QueryTemplate;
import template.RemoveQuery;
import template.RetrieveQuery;

public class ImageDAOImpl implements ImageDAO {
	private static ImageDAOImpl instance = new ImageDAOImpl();
	public static ImageDAOImpl getInstance(){
		return instance;
		}
	private ImageDAOImpl() {}
	private QueryTemplate q;
	@Override
	public void insert(Map<?,?> map) {
		q= new AddQuery();
		Map<String, Object> param = new HashMap<>();
		String a = map.get("fileName").toString();
		param.put("memId", map.get("memId"));
		param.put("imgName", a.substring(0, a.lastIndexOf(".")));
		param.put("extension", a.substring(a.lastIndexOf(".")+1));
		param.put("domain", "image");
		q.play(param);
	}

	@Override
	public List<ImageBean> selectSome(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageBean selectOne(String id) {
		q= new RetrieveQuery();
		Map<String, Object> map = new HashMap<>();
		map.put("domain", "image");
		map.put("id", id);
		q.play(map);
		return (ImageBean)q.getO();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(ImageBean img) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String word) {
		q =new RemoveQuery();
		HashMap<String, Object> map = new HashMap<>();
		map.put("memId", word);
		map.put("domain", "image");
		q.play(map);
	}
}
