package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request) {
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
			System.out.println("회원가입에 들어옴!!!");
			MemberBean mem = new MemberBean();
			mem.setMemId(request.getParameter("memid"));
			mem.setName(request.getParameter("name"));
			mem.setPassword(request.getParameter("password"));
			mem.setSsn(request.getParameter("ssn"));
			// MemberServiceImpl.getInstance().createMemId(mem);
			System.out.println("회원가입 성공!!");
			break;
		default:
			break;
		}

	}
}
