package enums;

public enum Path {
 CONTEXT, WEBPATH, MAIN, UPLOAD_PATH ;
	
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
		case UPLOAD_PATH : 
			r="C:\\Users\\1027\\eclipse\\jee-oxygen\\JeeWorkspace\\GMS-Model2\\WebContent\\resources\\img\\upload\\";
			break;
		}
		return r;
	}
}
