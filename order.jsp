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

<html>
<head><title>出前出張サービス◆虎乃庵◆</title></head>
<body>
<form action="logout" method="POST" name="logout">
	<input type="submit" value="ログアウト">
</form>
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
			<input type="button" name="<%=id %>_+" value="+1" onclick="1">
			</form>
			<form action="modify" method="POST">
			<input type="button" name="<%=id %>_-" value="-1">
			</form>
			<form action="modify" method="POST">
			<input type="button" name="<%=id %>_re" value="削除">
			</form>

			<form action="" method="get">
			<input type="submit" name="b1" value="button1">
			<input type="submit" name="b2" value="button2">
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
<form action="confirm" method="POST">
	<input type="submit" value="確認">
</form>
<p></p>
<form action="search" method="POST">
	<input type="submit" value="他にもご注文の方はこちら>>">
</form>
</body>
</html>