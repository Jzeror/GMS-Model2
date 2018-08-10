package command;

import javax.servlet.http.HttpServletRequest;
import lombok.Data;
@Data 
public class Command implements Order {
	protected String action, domain, view;
	protected HttpServletRequest request;

	@Override
	public void execute() {
		this.view = "/WEB-INF/view/"+domain+"/main.jsp";
	}
}
