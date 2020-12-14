<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
 <%@ include file="main.css" %>

</style>
</head>
<body>

<div class="sidenav">
  <%@ include file="menu.jsp" %>
</div>

<div class="main">
  <h1>Class Form</h1>
		<form action="<%=request.getContextPath()%>/classSubject" method="post">
			<table style="with: 100%">
				<tr>
					<td>Class</td>
					<td><input type="text" name="class" /></td>
				</tr>
				<tr>
					<td>Standard Name</td>
					<td><input type="text" name="standardName" /></td>
				</tr>
				<tr>
					<td>Standard section</td>
					<td><input type="text" name="standardSection" /></td>
				</tr>
				
				<tr>
					<td>Subject Name</td>
					<td><input type="text" name="subjectName" /></td>
				</tr>
				
				
				
				

			</table>
			<input type="submit" value="Submit" />
		</form>
</div>
  test 
</body>
</html>