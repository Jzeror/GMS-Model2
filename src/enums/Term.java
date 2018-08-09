package enums;

public enum Term {
 CONTEXT, WEBPATH, MAIN ;
	
	public String toString() {
		String r= "";
		switch(this) {
		case CONTEXT : r="context"; break;
		case WEBPATH : 
			r="/WEB-INF/view/";
			break;
		case MAIN : 
			r="/main.jsp";
			break;
		}
		return r;
	}
}
