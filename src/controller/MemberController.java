package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.Carrier;
import command.CountCommand;
import command.ListCommand;
import command.RetrieveCommand;
import command.SearchCommand;
import command.Sentry;
import domain.MemberBean;
import enums.Action;
import service.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Sentry.init(request);
		System.out.println(request.getContextPath());
		
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
			if (request.getParameter("page").equals("index")) {
				Carrier.redirect(request, response, "");
			} else {
				Carrier.forward(request, response);
			}
			break;
		case JOIN:
			Carrier.forward(request, response);
			break;
		case LIST:case SEARCH:case RETRIEVE:case COUNT:
			
			Carrier.forward(request, response);
			break;
		case UPDATE:
			Sentry.cmd.setPage("mypage");
			Sentry.cmd.execute();
			Carrier.forward(request, response);
			break;
		case DELETE:
			Carrier.redirect(request, response, "");
			break;
		case LOGIN:
			if (request.getAttribute("match").equals("TRUE")) {
				
				Carrier.forward(request, response);
			} else {
				Carrier.redirect(request, response, "/member.do?action=move&page=user_login_form");
			}
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
