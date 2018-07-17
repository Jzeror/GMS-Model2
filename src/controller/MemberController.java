package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String path = request.getServletPath();
		String action = request.getParameter("action");
		String page = request.getParameter("page");

		switch (action) {
		case "move":
			switch (page) {
			case "join_form":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "join_result":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "admin_login_form":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "admin_login_result":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "update_form":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "update_result":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "delete_form":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "delete_result":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "member_list":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "search_id_form":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "search_id_result":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "search_team_form":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "search_team_result":
				request.getRequestDispatcher("/WEB-INF/view/member/" + page + ".jsp").forward(request, response);
				break;
			case "index":
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			}
			break;
		default:
			System.out.println("오류 발생");
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
