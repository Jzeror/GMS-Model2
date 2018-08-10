package command;

import javax.servlet.http.HttpServletRequest;

import enums.*;

public class Commander {
	public static Command order(HttpServletRequest request) {
		Command cmd = null;
		switch (Action.valueOf(request.getParameter("action").toUpperCase())) {
		case ADD:
			cmd = new AddCommand(request);
			break;
		case MODIFY:
			cmd = new ModifyCommand(request);
			break;
		case REMOVE:
			cmd = new RemoveCommand(request);
			break;
		case RETRIEVE:
			cmd = new RetrieveCommand(request);
			break;
		case SEARCH:
			cmd = new SearchCommand(request);
			break;
		case LOGIN:
			cmd = new LoginCommand(request);
			break;
		case MOVE:
			cmd = new MoveCommand(request);
			break;
		}
		return cmd;
	}
}
