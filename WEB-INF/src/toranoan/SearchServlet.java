package toranoan;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchServlet extends HttpServlet{	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Bean bean = new Bean();
		HttpSession session = request.getSession(false);
		
		//メニュー名の検索
		String searchword = request.getParameter("searchitem");
		bean.setSearchitem(searchword);
		request.setAttribute("searchitem", bean);
		
		//カテゴリの検索
		String searchcategory = request.getParameter("searchcategory");
		bean.setSearchcategory(searchcategory);
		request.setAttribute("searchcategory", bean);		
		
		//検索結果の表示
		SearchDao itemsearcher = new SearchDao();
		List<String> itemresult =  (List<String>) itemsearcher.getSearch(searchword,searchcategory);
		session.setAttribute("itemresult", itemresult);
	
		// 次に遷移するページ(初期値)
		String nextPage = "/index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
	}
	
}