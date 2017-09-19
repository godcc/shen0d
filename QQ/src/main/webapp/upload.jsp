<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
<form action="/upload/test.do" enctype="multipart/form-data" method="post">
	<input type="file" name="file">
	<input type="submit" value="提交">
</form>

</body>
</html>