<%@page contentType="text/html; charset=utf-8"%>
<%@page import="toranoan.OrderServlet,toranoan.Item,toranoan.Bean,java.util.List,java.lang.Integer,java.util.Iterator,java.util.HashMap,java.util.regex.*,java.text.*"%>

<%
	// エンコーディング
	response.setContentType("text/html; charset=utf-8");
	request.setCharacterEncoding("utf-8");
	DecimalFormat exFormat = new DecimalFormat("#,###,###,##0");

	HashMap<String,Object> map = new HashMap<String,Object>();
	int amount = 0;

	if((session.getAttribute("ordermap")) != null) {
		map = (HashMap<String,Object>) session.getAttribute("ordermap");
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
	<style>
    #map_canvas {
		width: 500px;
		height: 500px;
	}
    </style>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?libraries=places&sensor=false"></script>
    <script type="text/javascript" src="/toranoan/map.js"></script>
   	<script type="text/javascript" src="/toranoan/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="/toranoan/controlledjquery.js"></script>
</head>
<body>
<form action="logout" method="POST" name="logout" id="submitform_logout">
	<input type="button" value="ログアウト" id="btn_logout">
</form>
<div style="float:right;margin:50 200 0 0;">
	近くのお店
	<div id="map_canvas"></div>
</div>
<h2>注文内容</h2>
<table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="#333333">
	<tr bgcolor="#EE0000">
		<th><font color="#FFFFFF">メニュー</font></th>
		<th><font color="#FFFFFF">値段</font></th>
		<th><font color="#FFFFFF">数量</font></th>
		<th><font color="#FFFFFF">金額</font></th>
	</tr>

<%
		Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            Object obj = it.next();
            Item itm = (Item) map.get(obj);
            String id = itm.getId();
            String item = itm.getItem();
            int price = itm.getPrice();
            int volume = itm.getVolume();
            int anamount = price*volume;
%>
	<tr>
		<td>
			<p><%=item %></p>
			<form action="modify" method="POST">
			<input type="submit" name="submit" value="+1">
			<input type="hidden" name="modify" value="<%=id %>_+">
			</form>
			<form action="modify" method="POST">
			<input type="submit" name="submit" value="-1">
			<input type="hidden" name="modify" value="<%=id %>_-">
			</form>
			<form action="modify" method="POST">
			<input type="submit" name="submit" value="削除">
			<input type="hidden" name="modify" value="<%=id %>_re">
			</form>
		</td>
		<td align="right">\<%=exFormat.format(price) %></td>
		<td align="center"><%=exFormat.format(volume) %></td>
		<td align="right">\<%=exFormat.format(anamount) %></td>
	</tr>
<%
			amount += anamount;
		}
%>
	<tr>
		<td align="center" colspan="3" style="font-weight:bold;">小計</td>
		<td align="right" style="font-weight:bold;">\<%=exFormat.format(amount) %></td>
	</tr>
</table>
<p>
こちらでよろしければ、確認ボタンを押してください。
</p>
<form action="confirm" method="POST" id="submitform_confirm">
	<input type="button" value="確認" id="btn_confirm">
</form>
<p></p>
<form action="search" method="POST" id="submitform_search">
	<input type="button" value="他にもご注文の方はこちら>>" id="btn_search">
</form>
</body>
</html>