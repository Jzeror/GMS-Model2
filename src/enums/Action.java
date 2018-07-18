package enums;

public enum Action {
MOVE,RETURN,LOGIN,JSP,WEB_INF_VIEW_MEMBER,
CREATE, LIST, SEARCH, RETRIEVE,COUNT,UPDATE,DELETE ;
	
	public String toString() {
		String a="";
		switch(this) {
		case MOVE :
			a="move";
			break;
		case RETURN :
			a="return";
			break;
		case CREATE :
			a="join";
			break;
		case LIST :
			a="memberlist";
			break;
		case SEARCH :
			a="searchMemberByTeam";
			break;
		case RETRIEVE :
			a="searchMemberById";
			break;
		case COUNT :
			a="memberCount";
			break;
		case UPDATE :
			a="memberUpdate";
			break;
		case LOGIN :
			a="login";
			break;
		case DELETE:
			a="delete";
			break;
		case WEB_INF_VIEW_MEMBER :
			a="/WEB-INF/view/member/";
			break;
		case JSP :
			a=".jsp";
			break;
		}
		return a;
	}
}
