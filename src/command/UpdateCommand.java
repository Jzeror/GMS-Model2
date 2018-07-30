package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		
			MemberBean mem = new MemberBean();
			mem.setMemId(request.getParameter("memId"));
			mem.setPassword(request.getParameter("pass"));
			mem.setRoll(request.getParameter("roll"));
			mem.setTeamId(request.getParameter("team"));
			MemberServiceImpl.getInstance().modifyMember(mem);
			setPage("mypage");
			super.execute();
		}
}
