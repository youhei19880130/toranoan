package toranoan;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SearchServlet2 extends HttpServlet{	

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
//		request.setAttribute("searchitem", bean);
		
		//カテゴリの検索
		String searchcategory = request.getParameter("searchcategory");
		bean.setSearchcategory(searchcategory);
//		request.setAttribute("searchcategory", bean);		
		
		//検索結果の表示
		SearchDao itemsearcher = new SearchDao();
		List itemresult =  (List) itemsearcher.getSearch(searchword,searchcategory);
//		session.setAttribute("itemresult", itemresult);
		
		//整形
		if(searchcategory == "") {
			searchcategory = "指定なし";
		}
		if(searchword == "") {
			searchword = "指定なし";
		}
		DecimalFormat exFormat = new DecimalFormat("#,###,###,##0");
		StringBuffer sb = new StringBuffer();
		sb.append("<br>");
		sb.append("<h2>検索結果</h2>");
		sb.append("----------------------------------------");
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td align=\"center\">検索ワード：</td>");
		sb.append("<td>"+searchword+"</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td align=\"center\">カテゴリ：</td>");
		sb.append("<td>"+searchcategory+"</td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append("----------------------------------------");
		sb.append("<br>");
		sb.append("<form action=\"order\" method=\"POST\" name=\"order\" id=\"submitform_order\">");
		sb.append("<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\" bordercolor=\"#333333\">");
		sb.append("<tr bgcolor=\"#EE0000\">");
		sb.append("<th><font color=\"#FFFFFF\">メニュー</font></th>");
		sb.append("<th><font color=\"#FFFFFF\">値段</font></th>");
		sb.append("<th><font color=\"#FFFFFF\">カテゴリー</font></th>");
		sb.append("<th><font color=\"#FFFFFF\">温・冷</font></th>");
		sb.append("<th><font color=\"#FFFFFF\">数量</font></th>");
		sb.append("</tr>");
		for (int i = 0; i<itemresult.size(); i++) {
			Bean s = (Bean) itemresult.get(i); 
			sb.append("<tr><td>"+s.getItem()+"</td> <td align=\"right\">\\"+exFormat.format(s.getPrice())
					+"</td> <td align=\"center\">"+s.getCategory()+"</td> <td align=\"center\">"
					+s.getHotcold()+"</td><td><input type=\"number\" min=\"0\" name=\""
					+s.getId()+"_"+s.getItem()+"_"+s.getPrice()+"\"></td></tr>");
		} 
		sb.append("</table>");
		sb.append("<input type=\"button\" value=\"注文\" id=\"btn_order\">");
		sb.append("</form>");
		sb.append("<form action=\"./order.jsp\" method=\"GET\" id=\"submitform_check\">");
		sb.append("<input type=\"button\" value=\"確認画面へ\" id=\"btn_check\">");
		sb.append("</form>");
//		System.out.println(sb);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(sb);
		
//		// 次に遷移するページ(初期値)
//		String nextPage = "/index.jsp";
//		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
//		rd.forward(request, response);
	}
	
}