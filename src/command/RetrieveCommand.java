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
		MemberBean mem = new MemberBean();
			mem.setMemId(request.getParameter("idsearch"));
		request.setAttribute("member", mem = MemberServiceImpl.getInstance().showList(mem));
		super.execute();}
}
