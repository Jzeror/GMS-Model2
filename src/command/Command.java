package command;

public class Command implements Order {
	protected String action, domain, page, view;


	public String getAction() {
		return action;
	}

	@Override
	public String toString() {
		return "Command [action=" + action + ", domain=" + domain + ", page=" + page + ", view=" + view + "]";
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	@Override
	public void execute() {
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
		
	}

}
