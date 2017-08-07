<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="shen0d" uri="http://cc.shen0d.web.bootstrap" %>
<!DOCTYPE html>
<%@ include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<shen0d:table url="/user/getAll.do" id="table1">
	<shen0d:tableColumn title="id" id="id"></shen0d:tableColumn>
	<shen0d:tableColumn title="用户名称" id="username"></shen0d:tableColumn>
</shen0d:table>
</body>
</html>