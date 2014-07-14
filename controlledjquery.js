//submitの置き換え
$(function(){
	$("#btn_login").click(function(){
		$("#submitform_login").submit();
	});
});

$(function(){
	$("#btn_logout").click(function(){
		$("#submitform_logout").submit();
	});
});

$(function(){
	$("#btn_search").click(function(){
		$("#result").empty();
		var item = $('#submitform_search [name=searchitem]').val();
		var category = $('#submitform_search [name=searchcategory]:checked').val();
		console.log(item);
		console.log(category);
		$("#loading").html("<img src='./img/gif-load.gif'/>");
		setTimeout(function(){
			$.ajax({
				type: "GET",
				url : "/toranoan/search",
				data: {
					"searchitem":item,
					"searchcategory":category
				},
				success : function(data) {
					// alert(data);
					$("#loading").empty();
					$("#result").append(data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$("#loading").empty();
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}
			});
		},500);
	});
});

$(function(){
	$('body').on('click','#btn_order',function(){
		$("#submitform_order").submit();
	});
});

$(function(){
	$('body').on('click','#btn_check',function(){
		$("#submitform_check").submit();
	});
});

// 7/14着手予定　//
/*$(function(){
	$("#btn_search").click(function(){
		$("#result").empty();
		var item = $('#submitform_search [name=searchitem]').val();
		var category = $('#submitform_search [name=searchcategory]:checked').val();
		console.log(item);
		console.log(category);
		$("#loading").html("<img src='./img/gif-load.gif'/>");
		// setTimeout(function(){
			$.ajax({
				type: "GET",
				url : "/toranoan/search",
				data: {
					"searchitem":item,
					"searchcategory":category
				},
				success : function(data) {
					// alert(data);
					$("#loading").empty();
					$("#result").append(data);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$("#loading").empty();
					alert("リクエスト時になんらかのエラーが発生しました：" + textStatus +":\n" + errorThrown);
				}
			});
		// },500);
	});
})*/

$(function(){
	$("#goto_btn_search").click(function(){
		$("#goto_submitform_search").submit();
	});
});

$(function(){
	$("#btn_confirm").click(function(){
		$("#submitform_confirm").submit();
	});
});