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

import command.Carrier;
import command.Sentry;
import domain.MemberBean;
import enums.Action;
import service.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getContextPath());
		System.out.println(request.getServletPath());
		System.out.println("MemberController ENTER!!");
		Sentry.init(request);
		switch (Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {
		case MOVE:
				Carrier.forward(request, response);	
			break;
		case JOIN:
			Carrier.redirect(request, response, "/member.do?action=move&page=admin_login_form");
			break;
		case LIST:
			Carrier.redirect(request, response, "/member.do?action=move&page=search_team_result");
			break;
		case SEARCH:
			Carrier.redirect(request, response, "/member.do?action=move&page=search_team_result");
			break;
		case RETRIEVE:
			Carrier.redirect(request, response,  "/member.do?action=move&page=admin_login_form");
			break;
		case COUNT:
			System.out.println(MemberServiceImpl.getInstance().showCountList());
			break;
		case UPDATE:
			Carrier.redirect(request, response, "");
			break;
		case DELETE:
			Carrier.redirect(request, response, "");
			break;
		case LOGIN:
			Carrier.redirect(request, response, "");
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
