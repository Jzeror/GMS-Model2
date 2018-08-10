
package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import service.MemberServiceImpl;

public class AddCommand extends Command {
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}

	@Override
	public void execute() {
		super.execute();
		MemberBean mem = new MemberBean();
		mem.setMemId(request.getParameter("memid"));
		mem.setName(request.getParameter("name"));
		mem.setPassword(request.getParameter("password"));
		mem.setSsn(request.getParameter("ssn"));
		mem.setGender(request.getParameter("gender"));
		mem.setAge(request.getParameter("age"));
		mem.setRoll(request.getParameter("roll"));
		mem.setTeamId(request.getParameter("teamid"));
		MemberServiceImpl.getInstance().add(mem);
		request.setAttribute("pagename", request.getParameter("page"));
	
	}
}
