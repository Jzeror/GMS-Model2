package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class ModifyCommand extends Command{
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		Map<String, Object> param = new HashMap<>();
		param.put("memId", request.getParameter("memId"));
		param.put("pass", request.getParameter("pass"));
		param.put("roll", request.getParameter("roll"));
		param.put("teamId", request.getParameter("teamId"));
		MemberServiceImpl.getInstance().modify(param);
		super.execute();
		request.setAttribute("pagename", request.getParameter("page"));
		}
}
