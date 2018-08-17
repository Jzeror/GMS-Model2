package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		request.setAttribute("pagename", request.getParameter("page"));
		request.setAttribute("user",MemberServiceImpl.getInstance().retrieve(request.getParameter("searchWord")));
		String a="";
		if(request.getParameter("searchWord")!=null) {
			a = request.getParameter("searchWord");
		}else if(request.getSession().getAttribute("user")!=null) {
			a = ((MemberBean)request.getSession().getAttribute("user")).getMemId();
		}
		if(ImageServiceImpl.getInstance().retrieve(a)!=null) {
			ImageBean img = ImageServiceImpl.getInstance().retrieve(a); 
			request.setAttribute("imgp",img.getImgName()+"."+img.getExtension());
		}
	}
}