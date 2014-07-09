<%@page contentType="text/html; charset=utf-8"%>

<%
	if (session.getAttribute("login") == null){
		response.sendRedirect("/toranoan/logout.jsp");
	}
%>

<html>
<head>
	<title>出前出張サービス◆虎乃庵◆</title>
	<script type="text/javascript" src="/toranoan/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="/toranoan/controlledjquery.js"></script>
</head>
<body>
<h2>ご注文完了</h2>
<p>ご注文ありがとうございました。<br>
またのご利用をお待ちしております。</p>
<p></p>
<form action="index.jsp" id="submitform_login">
	<input type="button" value="トップへ" id="btn_login">
</form>

</body>
</html>