package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {

		super.execute();
		switch(request.getParameter("searchOption")) {
		case "userId":
			MemberBean mem = new MemberBean();
			mem.setMemId(request.getParameter("searchWord"));
			request.setAttribute("user",MemberServiceImpl.getInstance().showList(mem));
			break;
		case "name": case "team_id":
			request.setAttribute("list", MemberServiceImpl.getInstance().showSomeList(request.getParameter("searchOption")+"/"+request.getParameter("searchWord"))); 
			break;
		}

			
		
		}
}
