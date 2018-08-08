package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberService;
import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	} 
	
	@Override
	public void execute() {
			String pageNumber = request.getParameter("pageNum");
			Map<String,Object> param = new HashMap<>();
			PageProxy pxy = new PageProxy();
			pxy.carryOut((pageNumber==null)? 1 : Integer.parseInt(pageNumber));
			Pagination page = pxy.getPagination();
			param.put("beginRow", String.valueOf(page.getBeginRow()));
			param.put("endRow", String.valueOf(page.getEndRow())) ;
			request.setAttribute("page", page);
			request.setAttribute("list", MemberServiceImpl.getInstance().search(param));
		super.execute();
	}
}

