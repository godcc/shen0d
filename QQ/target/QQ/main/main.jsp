<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<jsp:include page="/common/common.jsp"></jsp:include>
<body>
	<div>
		<div class="col-xs-12">
			<div align="right">${sessionScope.user.username } 你好</div>
		</div>
		<div class="col-xs-2" style="height: 100%;border: 1px solid #000">
			<ul>
				<li><a >菜单</a>
					<ul hidden="true">
						<li>人员管理</li>
						<li>功能开启</li>
						<li>文章发布</li>
						<li>系统管理</li>
						<li>运行环境</li>
						<li>当前任务</li>
					</ul>
				</li>
			</ul>
		</div>
		<div class="col-xs-10" style="height: 100%"></div>
	</div>
	

</body>
<script type="text/javascript">
	$(function(){
		$("a").on("click",function(){
			console.log($(this).find("ul").show());
			
		});
	})
</script>
</html>