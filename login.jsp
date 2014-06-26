<%@page contentType="text/html; charset=utf-8"%>
<%@page import="toranoan.AuthServlet"%>

<html>
<head><title>ログインページ</title></head>
<body>
<h3>ログインページ</h3>
<div style="width:300px; background-color:#F5E8E8; padding:10 0 10 10;">
<p><B>ID/PASSを記入してください。</B></p>
<%
    /* 認証失敗から呼び出されたのかどうか */
    Object status = session.getAttribute("status");

    if (status != null){
%>
      <p style="color:red; font-size:14px;">
      <% out.println("認証に失敗しました。"); %> 
      <br>
      <% out.println("再度ユーザー名とパスワードを入力して下さい。"); %> </p>
<%
      session.setAttribute("status", null);
    } else {
%>
<p>　<br>　</p>
<%
	}
%>

<form action="login" method="POST">
	<table>
		<tr>
			<td>ID</td>
			<td><input type="text" name="authid" size="30"></td>
		</tr>
		<tr>
			<td>PASS</td>
			<td><input type="password" name="authpass" size="30"></td>
		</tr>
	</table>
	<input type="submit" value="ログイン">
</form>
</div>
</body>
</html>