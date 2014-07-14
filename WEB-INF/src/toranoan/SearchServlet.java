package toranoan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		
		//カテゴリの検索
		String searchcategory = request.getParameter("searchcategory");
		bean.setSearchcategory(searchcategory);		
		
		//検索結果の表示
		SearchDao itemsearcher = new SearchDao();
		List itemresult =  (List) itemsearcher.getSearch(searchword,searchcategory);
		session.setAttribute("itemresult", itemresult);
		
		//整形
		StringBuffer sb = new StringBuffer();
		sb = SearchResult.searchResult(searchcategory, searchword, itemresult);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(sb);
	}	
}