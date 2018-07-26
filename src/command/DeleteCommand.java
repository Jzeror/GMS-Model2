package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class DeleteCommand extends Command{
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setAction(request.getParameter("page"));
		execute();
	}
@Override
	public void execute() {
			MemberBean mem = new MemberBean();
			mem.setMemId(request.getParameter("id"));
			mem.setPassword(request.getParameter("pass"));
			MemberServiceImpl.getInstance().removeMember(mem);
		super.execute();	}
	
}
