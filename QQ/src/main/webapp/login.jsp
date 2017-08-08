<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="common/common.jsp" %>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>后台登陆页面</title>
<link href="${ctx}/common/css/signin.css" rel="stylesheet">
</head>

<body>

	<div class="signin">
		<div class="signin-head">
			<img src="${ctx}/common/images/test/head_120.png" alt="" class="img-circle">
		</div>
		<form class="form-signin" id="loginForm" role="form">
			<input type="text" name="username" class="form-control" placeholder="用户名" required
				autofocus /> <input name="password" type="password" class="form-control"
				placeholder="密码" required />
			<button class="btn btn-lg btn-warning btn-block" type="button" onclick="onLogin()">登录</button>
		</form>
	</div>



</body>
<script type="text/javascript">
$(function(){
	//监控键盘按下的回车键
	$(window).keydown(function(event){
		if(event.key=="Enter"||event.keyCode==13){
			onLogin();
		}
	})
	
})
function onLogin(){
	$.customAjax({
		url:"/login.do",
		dataParams:$.serializeObj("#loginForm"),
		success:function(data){
			$.msg(data.msg)
			if(data.success){
				top.location.href='/webSocket.jsp'
			}
		}
		
	})
}
</script>
</html>
