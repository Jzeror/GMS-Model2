package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;

public class SearchCommand extends Command {
	public SearchCommand(HttpServletRequest request) {
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
			mem.setTeamId(request.getParameter("search"));
			// MemberServiceImpl.getInstance().createMemId(mem);
			//lst = MemberServiceImpl.getInstance().showSomeList(request.getParameter("search"));
			break;
		default:
			break;
		}
}
}