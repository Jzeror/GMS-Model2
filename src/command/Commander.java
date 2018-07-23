package command;

import javax.servlet.http.HttpServletRequest;

import enums.*;

public class Commander {
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE:
			cmd = new MoveCommand(request);
			break;
		case JOIN:
			cmd = new CreateCommand(request);
			break;
		case UPDATE:
			cmd = new UpdateCommand(request);
			break;
		case DELETE:
			cmd = new DeleteCommand(request);
			break;
		case RETRIEVE:
			cmd = new RetrieveCommand(request);
			break;
		case LOGIN:
			System.out.println("준 이자식 커맨더 : "+Sentry.cmd.getAction());
			cmd = new LoginCommand(request);
			break;
		case SEARCH:
			cmd = new SearchCommand(request);
			break;
		case LIST:
			cmd = new ListCommand(request);
			break;
		}
		return cmd;
	}
}
