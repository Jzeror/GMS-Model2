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
		// String path = request.getServletPath();
		System.out.println("MemberController ENTER!!");
		Sentry.init(request);
		System.out.println("액션: "+Sentry.cmd.getAction());
/*String action = request.getParameter("action");
		String page = request.getParameter("page");*/
		List<MemberBean> lst=null;
		MemberBean mem=null;

		switch (Sentry.cmd.getAction()) {
		case "move":
			try{
				Carrier.send(request, response);
			} catch(Exception e) {e.printStackTrace(eddfefefefuiheifheifhiehfiehfie);}
			break;
		case "return":
			break;
		case "join":
			System.out.println(request.getParameter("page"));
			mem = new MemberBean();
			mem.setMemId(request.getParameter("memid"));
			mem.setName(request.getParameter("name"));
			mem.setPassword(request.getParameter("password"));
			mem.setSsn(request.getParameter("ssn"));
			System.out.println(request.getParameter("ssn"));
			MemberServiceImpl.getInstance().createMemId(mem);*/
			
			break;
		case "memberlist":
			lst = MemberServiceImpl.getInstance().showAllList();			
			System.out.println("list 사이즈 : "+lst.size());
			break;
		case "searchMemberByTeam":
			lst =MemberServiceImpl.getInstance().showSomeList(request.getParameter("search"));
			System.out.println(lst);
			break;
		case "searchMemberById":
			mem=new MemberBean();
			mem.setMemId(request.getParameter("idsearch"));
			mem=MemberServiceImpl.getInstance().showList(mem);
			System.out.println(mem);
			break;
		case "memberCount":
			System.out.println(MemberServiceImpl.getInstance().showCountList());
			
			break;
		case "memberUpdate":
			mem=new MemberBean();
			mem.setMemId(request.getParameter("id"));
			mem.setPassword(request.getParameter("oldpass")+"/"+request.getParameter("newpass"));
			MemberServiceImpl.getInstance().modifyMember(mem);
			break;
		case "memberDelete":
			mem=new MemberBean();
			mem.setMemId(request.getParameter("id"));
			mem.setPassword(request.getParameter("pass"));
		MemberServiceImpl.getInstance().removeMember(mem);
			break;
		case "login":
			mem=new MemberBean();
			mem.setMemId(request.getParameter("id"));
			mem.setPassword(request.getParameter("pass"));
			mem=MemberServiceImpl.getInstance().login(mem);
			if(mem.getAge().equals("999")) {System.out.println("로그인실패");}else {System.out.println("로그인성공");}
			break;
		}
		request.getRequestDispatcher(Action.WEB_INF_VIEW_MEMBER + page + Action.JSP).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
