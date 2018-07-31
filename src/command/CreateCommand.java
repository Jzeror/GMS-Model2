
package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command {
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage("join_result");
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
		mem.setSubject(ParamMap.getValues(request, "subject"));
		if(MemberServiceImpl.getInstance().showOneList(mem)==true) {
			MemberServiceImpl.getInstance().createMemId(mem);
			request.setAttribute("createResult", "회원가입");
		}else {
			request.setAttribute("createResult", "아이디중복");
		}
		
	
	}
}
