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
import command.SearchCommand;
import command.RetrieveCommand;
import command.SearchCommand;
import command.Receiver;
import domain.MemberBean;
import enums.Action;
import service.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Receiver.init(request);		
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case ADD:
			Carrier.forward(request, response);
			break;
		case SEARCH:case RETRIEVE:
			Carrier.forward(request, response);
			break;
		case MODIFY:
			Receiver.cmd.execute();
			Carrier.forward(request, response);
			break;
		case REMOVE:
			//Carrier.redirect(request, response, "");
			break;
		case LOGIN:
			if (request.getAttribute("match").equals("TRUE")) {
				
				Carrier.forward(request, response);
			} else {
				Carrier.forward(request, response);
			}
			break;
		case MOVE:
				Carrier.forward(request, response);
				break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
