package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Term;

@WebServlet("/common.do")       // /가 들어가네. 배열인 경우 ({"","",""})
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
						request.getContextPath()
							+ "/resources/"+r.toString().toLowerCase());
			i++;
		}
		request.getRequestDispatcher(
				Term.WEBPATH.toString()
				+"/"+request.getServletPath()
					.split("/")[1]
					.split("\\.")[0]
				+Term.MAIN.toString())
			.forward(request, response);
	}
}
