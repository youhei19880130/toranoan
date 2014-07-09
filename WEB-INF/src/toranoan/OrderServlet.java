package toranoan;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		HashMap<String, Object> ordermap;
		if (session.getAttribute("ordermap") == null ) {
			ordermap = new HashMap<String,Object>();
		} else {
			ordermap = (HashMap<String, Object>) session.getAttribute("ordermap");
		}
		Enumeration<String> names = request.getParameterNames();
		int i=0;
		while (names.hasMoreElements()){
			String name = (String)names.nextElement();
			String vals[] = request.getParameterValues(name);
			if(vals[0] != "") {
				Item item = new Item();
				List resultlist = (List) session.getAttribute("itemresult"); 
				Bean s = (Bean) resultlist.get(i); 
				item.setBean(s);
				if (vals[0] == "0") {
					ordermap.remove(item.getId());
				} else {
					item.setVolume(Integer.parseInt(vals[0]));
					ordermap.put(item.getId(), item);
				}
			}
			i++;
		}
		session.setAttribute("ordermap", ordermap);
		
		// 次に遷移するページ(初期値)
		String nextPage = "/order.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
}
