package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.Carrier;
import command.Receiver;
import domain.*;
import enums.Action;
import enums.Path;
import service.ImageServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Receiver.init(request);		
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case ADD:
			Carrier.forward(request, response);
			break;
		case SEARCH:case RETRIEVE:
			Carrier.forward(request, response);
			break;
		case MODIFY:
			Receiver.cmd.execute();
			Carrier.forward(request, response);
			break;
		case REMOVE:
			//Carrier.redirect(request, response, "");
			break;
		case LOGIN:
				if(request.getAttribute("pagename").equals("main")) {
					Carrier.redirect(request, response,  "/common.do");
				}else {
					Carrier.forward(request, response);
				}
				
			break;
		case MOVE:
			Carrier.forward(request, response);
			break;
		case FILEUPLOAD:
			if(!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("업로드파일이 없습니다.");
				return;
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024*1024*40); // 40MB
			upload.setSizeMax(1024*1024*50); // 50MB
			List<FileItem> items = null;
			try {
				File file = null;
				items = upload.parseRequest(new ServletRequestContext(request)); 
				Iterator<FileItem> iter = items.iterator();
				while(iter.hasNext()) {
					FileItem item = (FileItem)iter.next(); //왜 캐스팅
					if(!item.isFormField()) {
						String fileName = item.getName();
						file = new File(Path.UPLOAD_PATH+fileName);
						item.write(file);
						// image table 에 id, image name, ext 저장.
						Map<String, Object> map = new HashMap<>();
			map.put("memId",((MemberBean)(request.getSession().getAttribute("user"))).getMemId());
			map.put("fileName",fileName);
			ImageServiceImpl.getInstance().add(map);
					}else {
						System.out.println("=========파일업로드 실패");
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Carrier.redirect(request, response, "/member.do?action=retrieve&page=retrieve");
			break;
		default:
			Carrier.redirect(request, response, "");
			break;
		}
	}
}
