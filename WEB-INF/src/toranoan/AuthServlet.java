package toranoan;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




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
		
		boolean check = authUser(authid, authpass);
		if (check){
			/* 認証済みにセット */
			session.setAttribute("login", "OK");

			/* 本来のアクセス先へ飛ばす */
			String target = "/toranoan/index.jsp";
			response.sendRedirect(target);
		}else{
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("status", "Not Auth");
		    response.sendRedirect("/toranoan/login.jsp");
		}
	}
	
	public boolean authUser(String authid, String authpass) {
		if (authid == null || authid.length() == 0 || authpass == null || authpass.length() == 0){
			return false;
		} 
		
		String sql = "SELECT USERPASS FROM USERLIST WHERE USERID = '"+authid
											+"' and USERPASS ='"+authpass+"'";
		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			
		    if (rs.next()){
		    	return true;
		    }else{
		    	return false;
		    }			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ihnore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
	return false;
	}
}

