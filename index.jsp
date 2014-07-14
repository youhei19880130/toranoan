<%@page contentType="text/html; charset=utf-8"%>
<%@page import="toranoan.Bean,toranoan.SearchServlet,toranoan.AuthServlet,toranoan.SearchDao,java.util.List,java.text.*"%>

<%
	// エンコーディング
	response.setContentType("text/html; charset=utf-8");
	request.setCharacterEncoding("utf-8");
	DecimalFormat exFormat = new DecimalFormat("#,###,###,##0");
	
	Bean bean = new Bean();
	String searchitem = null;
	String searchcategory = null;

	if((request.getAttribute("searchitem")) != null) {
		bean = (Bean) request.getAttribute("searchitem");
		searchitem = bean.getSearchitem();
	}

	if((request.getAttribute("searchcategory")) != null) {
		bean = (Bean) request.getAttribute("searchcategory");
		searchcategory = bean.getSearchcategory();
	}
 %>

<%
	if (session.getAttribute("login") == null){
		response.sendRedirect("/toranoan/logout.jsp");
	}
%>

<html>
<head>
	<title>出前出張サービス◆虎乃庵◆</title>
	<script type="text/javascript" src="/toranoan/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="/toranoan/jquery.validate.min.js"></script>
	<script type="text/javascript" src="/toranoan/controlledjquery.js"></script>
<!-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	 <script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script> -->
<!-- <script type="text/javascript">
		$( "#btn_sub" ).validate({
		  rules: {
		    number: {
		      // required: true,
		      number: true
		    }
		  }
		});
	</script> -->
</head>
<body>
<form action="logout" method="POST" name="logout" id="submitform_logout">
	<input type="button" value="ログアウト" id="btn_logout">
</form>
<h1>虎乃庵</h1>
<form action="search" method="GET" name="search"  id="submitform_search">
	<table>
		<tr>
			<td>お品書き</td>
			<td><input type="text" name="searchitem" size="40"></td>
		</tr>
		<tr>
			<td>カテゴリ</td>
			<td>
			<input type="radio" name="searchcategory" value="そば">そば
			<input type="radio" name="searchcategory" value="うどん">うどん
			<input type="radio" name="searchcategory" value="飲み物">飲み物
			</td>
		</tr>
	</table>
	<br>
	<input type="button" value="検索" id="btn_search">
</form>
<div id="loading"></div>
<div id="result"></div>

<!-- <%
	if (searchitem == null 
			&& searchcategory == null) {
		searchitem = "指定なし";
		searchcategory = "指定なし";
	} else {
		if ("".equals(searchitem)) {
			if (searchcategory == null) {
				searchitem = "指定なし";
				searchcategory = "指定なし";
			} else {
				searchitem = "指定なし";		
			}
		} else {
			if (searchcategory == null) {
				searchcategory = "指定なし";
			} else {
			}		
		}
%>
<br>
<h2>検索結果</h2>
----------------------------------------
<table>
	<tr>
		<td align="center"><% out.print("検索ワード： ");%></td>
		<td><% out.print(searchitem); %></td>
	</tr>
	<tr>
		<td align="center"><% out.print("カテゴリ：　"); %></td>
		<td><% out.print(searchcategory); %></td>
	</tr>
</table>
----------------------------------------
<br>
<form action="order" method="POST" name="order" id="submitform_order">
	<table border="1" cellspacing="0" cellpadding="5" bordercolor="#333333">
		<tr bgcolor="#EE0000">
			<th><font color="#FFFFFF">メニュー</font></th>
			<th><font color="#FFFFFF">値段</font></th>
			<th><font color="#FFFFFF">カテゴリー</font></th>
			<th><font color="#FFFFFF">温・冷</font></th>
			<th><font color="#FFFFFF">数量</font></th>
		</tr>
<%
		List resultlist = (List) session.getAttribute("itemresult");
		for (int i = 0; i<resultlist.size(); i++) {
%>
		<tr>
<%
			Bean s = (Bean) resultlist.get(i); 
			out.println("<td>"+s.getItem()+"</td> <td align=\"right\">\\"+exFormat.format(s.getPrice())
				+"</td> <td align=\"center\">"+s.getCategory()+"</td> <td align=\"center\">"
				+s.getHotcold()+"</td><td><input type=\"number\" min=\"0\" name=\""
				+s.getId()+"_"+s.getItem()+"_"+s.getPrice()+"\"></td>");
		} 
%>
		</tr>
	</table>
	<input type="button" value="注文" id="btn_order">
</form>
<form action="./order.jsp" method="GET" id="submitform_check">
		<input type="button" value="確認画面へ" id="btn_check">
</form>
<%
	}
%> -->
</body>
</html>