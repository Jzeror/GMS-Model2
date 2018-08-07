package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberService;
import service.MemberServiceImpl;

public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	} 
	
	@Override
	public void execute() {
			int count = MemberServiceImpl.getInstance().showCountList();
			int pageNum = (request.getParameter("pageNum")==null)? 1 : Integer.parseInt(request.getParameter("pageNum"));
			int pageSize = 5;	//정렬이 필요해지면 상수는 바뀜.		
			Map<String,Object> param = new HashMap<>();
			param.put("beginRow", String.valueOf((pageNum-1)*pageSize+1));
			param.put("endRow", String.valueOf((pageNum*pageSize>count)? count : pageNum*pageSize )) ;
			 request.setAttribute("list", MemberServiceImpl.getInstance().showAllList55555(param));  
			 request.setAttribute("count",count);  
			 request.setAttribute("beginPage", (request.getParameter("endPage")==null)?1:Integer.valueOf(request.getParameter("endPage"))+1);
			 request.setAttribute("endPage", ((int)request.getAttribute("beginPage")<count/5)? (int)request.getAttribute("beginPage")+4 :count/5+((count%5==0)?0:1));
			/* boolean existPrev = false;
				if(prevBlock >= 0) {
					existPrev = true;
				}
				boolean existNext = false;
				if(nextBlock <= 0) {
					existNext = true;
				}*/
			 request.setAttribute("countTF", ((int)request.getAttribute("endPage")*pageSize>=count)? "FALSE" : "TRUE");
		super.execute();
	}
}

