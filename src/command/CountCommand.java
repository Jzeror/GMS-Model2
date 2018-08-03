package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberServiceImpl;

public class CountCommand extends Command {
	public CountCommand() {
		setRequest(request);
		setDomain("admin");
		setAction("count");
		setPage("main");
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		MemberServiceImpl.getInstance().createR();
		/*request.setAttribute("count",
				MemberServiceImpl.getInstance().showCountList());*/
		/*super.execute();*/
	}
	
}
