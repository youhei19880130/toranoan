$(function() {
	var requestObj = {
		message : null,
	};
	$("#request").click(function() {
		//リクエスト用のオブジェクトに値を詰め込む
		requestObj.message = $("#message").val();
		//JavaScriptのオブジェクトをJSONに変換する

/*		var requestJson = $.toJSON(requestObj);
		console.log(requestJson);*/
		console.log(requestObj.message);

		$("#loading").html("<img src='../img/gif-load.gif'/>");
		setTimeout(function(){
			$.ajax({
				type: "GET",
				url : "/toranoan/jsontest",
				data: {requestJs : requestObj.message},
				// timeout: 5000,
				success : function(data) {
					// alert(data.responseMessage);
					$("#loading").empty();
					$("#result").append(data.responseMessage);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$("#loading").empty();
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}
			});
		},1000);
	});
});