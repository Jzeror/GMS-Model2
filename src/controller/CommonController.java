package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enums.Domain;
import enums.Term;

@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	enum Resources{
		CONTEXT,CSS,JS,IMG
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i = 0;
		for(Resources r: Resources.values()) {
				request.getSession()
				.setAttribute(r.toString().toLowerCase(),
						(i==0)?
						request.getContextPath() :
							request.getContextPath()+
							"/resources/"+r.toString().toLowerCase());
			i++;
		}
		/*	HttpSession session = request.getSession();
		session.setAttribute(Domain.CONTEXT.toString(), request.getContextPath());*/
		//setAttr가 된 session객체의 값을 request에 넣어주지 않았는데 어떻게?
		request.getRequestDispatcher(Term.WEBPATH.toString()+Term.MAIN.toString())
		.forward(request, response);
	}
}
