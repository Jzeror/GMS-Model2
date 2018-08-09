package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void forward(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher(Receiver.cmd.getView()).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) {
		try {
			response.sendRedirect(request.getContextPath() + url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
