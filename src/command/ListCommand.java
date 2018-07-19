package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;

public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request) {
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
			//lst = MemberServiceImpl.getInstance().showAllList();
			break;
		default:
			break;
		}

	}
}
