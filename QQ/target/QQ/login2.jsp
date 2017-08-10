<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<jsp:include page="/common/common.jsp"></jsp:include>
<body>

	<div class="container">
		<div align="center">
			<form id="loginForm" class="form-horizontal">
				<div class="form-group">
					<label class="col-sm-2 control-label">请输入用户名称</label>
					<div class="col-sm-10">
						<input class=" form-control" type="text" name="username" placeholder="请输入用户账户名">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">请输入用户密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" name="password"  placeholder="请输入用户账户名">
					</div>
				</div>
				<button class="btn btn-success" type="button" onclick="onLogin()">登录</button>
			</form>
		</div>
	</div>

</body>

<script type="text/javascript">
function onLogin(){
	$.customAjax({
		url:"/login.do",
		dataParams:$.serializeObj("#loginForm"),
		success:function(data){
			alert(data.msg)
			if(data.success){
				top.location.href='/webSocket.jsp'
			}
		}
		
	})
}
</script>
</html>