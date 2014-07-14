package toranoan;

import java.text.DecimalFormat;
import java.util.List;

public class SearchResult {
	public static StringBuffer searchResult(String searchcategory, String searchword, List itemresult) {
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
		return sb;
	}
}
