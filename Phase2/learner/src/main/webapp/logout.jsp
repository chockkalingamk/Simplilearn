<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Logout Form</h1>
		You have successfully Logout!!!! Please login again to continue
		<form action="<%=request.getContextPath()%>/login" method="post">
		<a href="login">Login</a>
		</form>
	</div>
</body>
</body>
</html>