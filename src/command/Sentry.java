package command;

import javax.servlet.http.HttpServletRequest;

public class Sentry {
	public static Command cmd= new Command();
	public static void init(HttpServletRequest request) {
		System.out.println("준 이자식 센트리 : "+Sentry.cmd.getAction());
		cmd = Commander.order(request);
	}
}
