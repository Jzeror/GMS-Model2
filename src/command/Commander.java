package command;

public class Commander {
	public static Command order(String domain,String action,String page) {
		Command cmd = null;
		switch (action) {
		case "move":
			System.out.println("--무브진입--");
			cmd = new MoveCommand(domain,action,page);
			break;
		}
		return cmd;
	}
}
