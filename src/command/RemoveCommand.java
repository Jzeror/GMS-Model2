package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RemoveCommand extends Command {
	public RemoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}

	@Override
	public void execute() {
		MemberBean mem = new MemberBean();
		mem.setMemId(((MemberBean)request.getSession().getAttribute("user")).getMemId());
		mem.setPassword(request.getParameter("pass"));
		MemberServiceImpl.getInstance().remove(mem);
		request.getSession().invalidate();
		super.execute();
		request.setAttribute("pagename", request.getParameter("page"));
	}
}