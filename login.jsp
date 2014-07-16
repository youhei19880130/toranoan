<%@page contentType="text/html; charset=utf-8"%>
<%@page import="toranoan.AuthServlet"%>

<html>
<head>
	<title>ログインページ</title>
	<script type="text/javascript" src="/toranoan/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="/toranoan/controlledjquery.js"></script>
</head>
<body>
<h3>ログインページ</h3>
<div style="width:300px; background-color:#F5E8E8; padding:10 0 10 10;">
<p><B>ID/PASSを記入してください。</B></p>
<form action="login" method="POST" id="submitform_login">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="entryid" size="30"></td>
		</tr>
		<tr>
			<td>PASS</td>
			<td><input type="password" name="entrypass" size="30"></td>
		</tr>
	</table>
<%
    /* 認証失敗から呼び出されたのかどうか */
    Object status = session.getAttribute("status");

    if (status != null){
%>
      	<p style="color:red; font-size:14px;">
<%
		out.println("認証に失敗しました。"); 
%>
<br>
<%
    	out.println("再度ユーザー名とパスワードを入力して下さい。");
%>
    	</p>
<%
      	session.setAttribute("status", null);
    } 
%>
	<input type="button" value="ログイン" id="btn_login">
</form>
</div>
</body>
</html>