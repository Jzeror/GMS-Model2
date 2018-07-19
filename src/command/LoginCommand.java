package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command{
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			MemberBean mem = new MemberBean();
			mem.setMemId(request.getParameter("id"));
			mem.setPassword(request.getParameter("pass"));
			mem = MemberServiceImpl.getInstance().login(mem);
/*			if (mem.getAge().equals("999")) {
				System.out.println("로그인실패");
			} else {
				System.out.println("로그인성공");
			}*/
			break;
		default:
			break;
		}
}}
