package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command {
	public DeleteCommand(HttpServletRequest request) {
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
		MemberServiceImpl.getInstance().removeMember(mem);
		request.getSession().invalidate();
		super.execute();
	}
}
