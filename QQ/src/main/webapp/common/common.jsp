<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
	application.setAttribute("ctx", context);
	out.write(context);
%>

<!DOCTYPE html>
<html>
<head>
<script >
var ctx =${ctx}+"/"
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/lib/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/lib/bootstrap-table/bootstrap-table.min.css">
<link rel="stylesheet" type="text/css" href="${ctx}/lib/zTree/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" type="text/css" href="${ctx}/lib/bootstrap/dist/css/bootstrap-theme.css">
<script type="text/javascript" src="${ctx}/lib/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/lib/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="${ctx}/lib/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${ctx}/lib/bootstrap-validator/dist/js/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="${ctx}/lib/layer-v3.0.3/layer/layer.js"></script>
<script type="text/javascript" src="${ctx}/lib/zTree/jquery.ztree.core.min.js"></script>

<script type="text/javascript" src="${ctx}/common/package.js"></script>
<script type="text/javascript" src="${ctx}/common/js/common.js"></script>
<script type="text/javascript" src="${ctx}/common/common1.js"></script>
<script type="text/javascript" src="${ctx}/common/common_jQueryExtends.js"></script>
</head>
<body>

</body>
</html>