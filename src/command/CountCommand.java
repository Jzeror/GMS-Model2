package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberServiceImpl;

public class CountCommand extends Command {
	public CountCommand(HttpServletRequest request, HttpServletResponse response) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		request.setAttribute("count",
				MemberServiceImpl.getInstance().showCountList());
		super.execute();
	}
	
}
