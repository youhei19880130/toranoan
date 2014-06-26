/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.8
 * Generated at: 2014-06-26 12:38:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import toranoan.Bean;
import toranoan.SearchServlet;
import toranoan.AuthServlet;
import toranoan.SearchDao;
import java.util.List;
import java.text.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	// エンコーディング
	response.setContentType("text/html; charset=utf-8");
	request.setCharacterEncoding("utf-8");
	DecimalFormat exFormat = new DecimalFormat("#,###,###,##0");
	
	if((request.getAttribute("searchitem")) != null) {
	Bean bean = (Bean) request.getAttribute("searchitem");
	String searchitem = bean.getSearchitem();
	}

	if((request.getAttribute("searchcategory")) != null) {
	Bean bean = (Bean) request.getAttribute("searchcategory");
	String searchcategory = bean.getSearchcategory();
	}

 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head><title>出前出張サービス◆虎乃庵◆</title></head>\r\n");
      out.write("<body>\r\n");
      out.write("<form action=\"logout\" method=\"POST\" name=\"logout\">\r\n");
      out.write("\t<input type=\"submit\" value=\"ログアウト\">\r\n");
      out.write("</form>\r\n");
      out.write("<h1>虎乃庵</h1>\r\n");
      out.write("<form action=\"search\" method=\"GET\" name=\"search\">\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>お品書き</td>\r\n");
      out.write("\t\t\t<td><input type=\"text\" name=\"searchitem\" size=\"40\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>カテゴリ</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"searchcategory\" value=\"そば\">そば\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"searchcategory\" value=\"うどん\">うどん\r\n");
      out.write("\t\t\t<input type=\"radio\" name=\"searchcategory\" value=\"飲み物\">飲み物\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<input type=\"submit\" value=\"検索\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");

	if ((session.getAttribute("searchitem")) == null 
		&& (session.getAttribute("searchcategory")) == null) {
	} else {
		Bean bean = (Bean) session.getAttribute("searchitem");
		String searchitem = bean.getSearchitem();
		bean = (Bean) session.getAttribute("searchcategory");
		String searchcategory = bean.getSearchcategory();
		if (searchitem != "" ) {
			if (searchcategory != null) {
			} else {
				searchcategory = "指定なし";
			}
		} else {
			if ((session.getAttribute("searchcategory")) != null) {
				searchitem = "指定なし";
			} 
		}

      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("<h2>検索結果</h2>\r\n");
      out.write("----------------------------------------\r\n");
      out.write("<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\">");
 out.print("検索ワード： ");
      out.write("</td>\r\n");
      out.write("\t\t<td>");
 out.print(searchitem); 
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td align=\"center\">");
 out.print("カテゴリ：　"); 
      out.write("</td>\r\n");
      out.write("\t\t<td>");
 out.print(searchcategory); 
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write("----------------------------------------\r\n");
      out.write("<br>\r\n");
      out.write("<form action=\"order\" method=\"POST\" name=\"order\">\r\n");
      out.write("\t<table border=\"1\" cellspacing=\"0\" cellpadding=\"5\" bordercolor=\"#333333\">\r\n");
      out.write("\t\t<tr bgcolor=\"#EE0000\">\r\n");
      out.write("\t\t\t<th><font color=\"#FFFFFF\">メニュー</font></th>\r\n");
      out.write("\t\t\t<th><font color=\"#FFFFFF\">値段</font></th>\r\n");
      out.write("\t\t\t<th><font color=\"#FFFFFF\">カテゴリー</font></th>\r\n");
      out.write("\t\t\t<th><font color=\"#FFFFFF\">温・冷</font></th>\r\n");
      out.write("\t\t\t<th><font color=\"#FFFFFF\">数量</font></th>\r\n");
      out.write("\t\t</tr>\r\n");

		List resultlist = (List) session.getAttribute("itemresult");
		for (int i = 0; i<resultlist.size(); i++) {

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");

			Bean s = (Bean) resultlist.get(i); 
			out.println("<td>"+s.getItem()+"</td> <td align=\"right\">\\"+exFormat.format(s.getPrice())
				+"</td> <td align=\"center\">"+s.getCategory()+"</td> <td align=\"center\">"
				+s.getHotcold()+"</td><td><input type=\"number\" min=\"0\" name=\""
				+s.getId()+"_"+s.getItem()+"_"+s.getPrice()+"\"></td>");
		} 

      out.write("\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<input type=\"submit\" value=\"注文\">\r\n");
      out.write("</form>\r\n");
      out.write("<form action=\"./order.jsp\" method=\"GET\">\r\n");
      out.write("\t\t<input type=\"submit\" value=\"確認画面へ\">\r\n");
      out.write("</form>\r\n");

	}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
