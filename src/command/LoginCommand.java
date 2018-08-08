package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("mypage");
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		MemberBean mem = new MemberBean();
		mem.setMemId(request.getParameter("memId"));
		mem.setPassword(request.getParameter("pass"));
		mem=MemberServiceImpl.getInstance().login(mem);
		if (MemberServiceImpl.getInstance().checkId(mem) == false && !mem.getAge().equals("999")) {
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", MemberServiceImpl.getInstance().login(mem));
		} else {
			request.setAttribute("match", "FALSE");
		}
	}
}
