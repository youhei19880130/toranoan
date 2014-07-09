package toranoan;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class AuthServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		String authid = request.getParameter("authid");
		String authpass = request.getParameter("authpass");
		HttpSession session = request.getSession(true);
		boolean check = AuthDao.authUser(authid, authpass);
		if (check){
			/* 認証済みにセットし、本来のアクセス先へ飛ばす */
			session.setAttribute("login", "OK");
			String target = "/toranoan/index.jsp";
			response.sendRedirect(target);
		}else{
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("status", "Not Auth");
		    response.sendRedirect("/toranoan/login.jsp");
		}
	}
	
}

