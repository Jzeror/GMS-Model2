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
		execute();
	} 
	@Override
	public void execute() {
			String pageNumber = request.getParameter("pageNum");
			Map<String,Object> param = new HashMap<>(); 
			PageProxy pxy = new PageProxy();
			pxy.carryOut((pageNumber==null)? 1 : Integer.parseInt(pageNumber));
			Pagination page = pxy.getPagination();
			if(request.getParameter("searchOption")!=null) {
				String[] arr1 = {"beginRow","endRow","searchOption","searchWord"};
				String[] arr2 = {
						
						String.valueOf(page.getBeginRow()),
						String.valueOf(page.getEndRow()),
						request.getParameter("searchOption"),
						request.getParameter("searchWord")
				};
				for(int i=0 ; i<arr1.length ; i++) {
					param.put(arr1[i], arr2[i]);
				}
			}else {
				String[] arr1 = {"beginRow","endRow"};
				String[] arr2 = {
						String.valueOf(page.getBeginRow()),
						String.valueOf(page.getEndRow())
			};
				for(int i=0 ; i<arr1.length ; i++) {
					param.put(arr1[i], arr2[i]);
				}
				}
			request.setAttribute("pagename", request.getParameter("page"));
			request.setAttribute("page", page);
			request.setAttribute("list", MemberServiceImpl.getInstance().search(param));
			super.execute();
	}
}

