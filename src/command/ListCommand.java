package command;

import java.util.ArrayList;
import java.util.List;

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
			 request.setAttribute("list", MemberServiceImpl.getInstance().showAllList());  
			 request.setAttribute("count",MemberServiceImpl.getInstance().showCountList());  
			/* request.getSession().setAttribute("list", MemberServiceImpl.getInstance().showAllList());*/
		super.execute();
	}
}
