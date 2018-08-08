package command;

import java.util.HashMap;
import java.util.Map;

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
		Map<String, Object> param = new HashMap<>();
		param.put("memID", request.getParameter("memId"));
		param.put("pass", request.getParameter("pass"));
		param.put("roll", request.getParameter("roll"));
		param.put("teamId", request.getParameter("teamId"));
		param.put("memID", request.getParameter("memId"));
		
		MemberServiceImpl.getInstance().modify(param);
			setPage("mypage");
			super.execute();
		}
}
