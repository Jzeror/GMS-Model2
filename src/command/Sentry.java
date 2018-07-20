package command;

import javax.servlet.http.HttpServletRequest;

public class Sentry {
	public static Command cmd= new Command();
	public static void init(HttpServletRequest request) {
		String servletPath=request.getServletPath();
		cmd = Commander.order(request);
	}
}
