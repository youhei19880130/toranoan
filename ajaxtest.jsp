<%@page contentType="text/html; charset=utf-8"%>
<%@page import="toranoan.AjaxTestServlet" %>

<!DOCTYPE html>
<html>
<head>
<title>JSON TEST</title>
<script type="text/javascript" src="./jquery-1.11.1.js"></script>
<script type="text/javascript" src="./jquery.json-2.4.js"></script>
<script type="text/javascript" src="./test.js" charset="utf-8"></script>

</head>
<body>
<p>サーブレットへのリクエストに投げるメッセージを入力してください。：</p>
<input type="text" size="30" id="message">
<input type="button" id="request" value="送信する">

<div id="result">
<p>結果：</p>
<div id="loading" />
</div>

</body>
</html>