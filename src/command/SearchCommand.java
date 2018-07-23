package command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	protected List<MemberBean> lst;
	public List<MemberBean> getLst() {
		return lst;
	}
	public SearchCommand(HttpServletRequest request) {
			setRequest(request);
			setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
			setAction(request.getParameter("action"));
			setPage(request.getParameter("page"));
			execute();
		}
	@Override
	public void execute() {


	request.setAttribute("memlist", MemberServiceImpl.getInstance().showSomeList(request.getParameter("search"))); 
		super.execute();}
}