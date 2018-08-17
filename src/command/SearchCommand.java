package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import proxy.PageProxy;
import proxy.Pagination;
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
			param.put("pageNumber", (pageNumber==null)? 1 : Integer.parseInt(pageNumber));
			if(request.getParameter("searchOption")==null || request.getParameter("searchOption").equals("") ) {
				param.put("searchOption","none");
			}else {
				param.put("searchOption", request.getParameter("searchOption"));
				request.setAttribute("exSearchOption",request.getParameter("searchOption"));
			}
			if(request.getParameter("searchWord")==null || request.getParameter("searchWord").equals("")) {
				param.put("searchWord","none");
			}else {
				param.put("searchWord", request.getParameter("searchWord"));
				request.setAttribute("exSearchWord", request.getParameter("searchWord"));
			}
			PageProxy pxy = new PageProxy();
			pxy.carryOut(param);
			Pagination page = pxy.getPagination();
			String[] arr1 = {"beginRow","endRow"};
			String[] arr2 = {
					String.valueOf(page.getBeginRow()),
					String.valueOf(page.getEndRow())
			};
			for(int i=0 ; i<arr1.length ; i++) {
				param.put(arr1[i], arr2[i]);
			}										//row setting
			request.setAttribute("pagename", request.getParameter("page"));
			request.setAttribute("page", page);
			request.setAttribute("list", MemberServiceImpl.getInstance().search(param));
			super.execute();
	}
}