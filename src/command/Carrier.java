package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	/* public static Command cmd = new Command(); */
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("뷰: " + Sentry.cmd.getView());
			request.getRequestDispatcher(Sentry.cmd.getView()).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) {
		try {

			response.sendRedirect(request.getContextPath() + url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
