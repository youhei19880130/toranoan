package toranoan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ModifyServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		HashMap<String, Object> ordermap = (HashMap<String, Object>) session.getAttribute("ordermap");
		String amdf = (String) request.getParameter("modify");
		String[] mdf = amdf.split("_");
		String mdfname = mdf[0];
		String mdfact = mdf[1];
		Item item = (Item) ordermap.get(mdfname);
		int volume = item.getVolume();
		switch (mdfact) {
		case "+":
			item.setVolume(volume+1);
			ordermap.put(mdfname,item);
			break;
		case "-":
			item.setVolume(volume-1);
			ordermap.put(mdfname,item);			
			break;
		case "re":
			ordermap.remove(mdfname);						
			break;		
		}
		session.setAttribute("ordermap", ordermap);
		
		// 定型文
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.print(xxx);
		
//		// 次に遷移するページ(初期値)
//		String nextPage = "/order.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
//		rd.forward(request, response);
	}
	
}
