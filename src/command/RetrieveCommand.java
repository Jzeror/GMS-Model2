package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		request.setAttribute("pagename", request.getParameter("page"));
			request.setAttribute("user",MemberServiceImpl.getInstance().retrieve(request.getParameter("searchWord")));
		}
}
