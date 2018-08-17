package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		if(request.getSession().getAttribute("log")!=null) {
			request.getSession().invalidate();
			request.setAttribute("pagename", "main");
		}else {
			MemberBean mem = new MemberBean();
			mem.setMemId(request.getParameter("memId"));
			mem.setPassword(request.getParameter("pass"));
			request.setAttribute("pagename", request.getParameter("page"));
			if (!MemberServiceImpl.getInstance().login(mem).getAge().equals("999")) {
				request.setAttribute("match", "TRUE");
				request.getSession().setAttribute("user", MemberServiceImpl.getInstance().login(mem));		
				request.getSession().setAttribute("log", "login");
				if(ImageServiceImpl.getInstance().retrieve(((MemberBean)request.getSession().getAttribute("user")).getMemId())!=null) {
					ImageBean img = ImageServiceImpl.getInstance().retrieve(((MemberBean)request.getSession().getAttribute("user")).getMemId()); 
					request.setAttribute("imgp",img.getImgName()+"."+img.getExtension());
				}
			} else {
				request.setAttribute("match", "FALSE");
			}
		}
	}
}
