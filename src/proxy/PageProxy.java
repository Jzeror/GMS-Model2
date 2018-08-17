package proxy;

import java.util.Map;

import lombok.Data;

@Data
public class PageProxy implements Proxy{
	private Pagination pagination;
	@Override
	public void carryOut(Map<?,?> map) {
		this.pagination = new Pagination();
		pagination.carryOut(map);
	}
	
	
}
