<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.project.bean.* "%>
<%@ page import="java.util.* "%>
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
  <h1>Class Student Form</h1>
		<form action="<%=request.getContextPath()%>/classesStudents" method="post">
			<table style="with: 100%">
				<tr>
					<td>Class Name</td>
					<%
						ArrayList<Classes> listObj = (ArrayList<Classes>) request.getAttribute("listClasses");
					%>


					<td><select name="classId" size="<%listObj.size();%>"
						>
							<option value="">--Select---</option>
							<%
								for (Iterator i = listObj.iterator(); i.hasNext();) {
									Classes c = (Classes) i.next();
							%>
							<option value="<%=c.getClassId()%>">
								<%=c.getClassName()%>
							</option>
							<% } %>
					</SELECT></td>
				</tr>
				
				<tr>
					<td>Student Id</td>
					<td><input type="text" name="studentId" /></td>
				</tr>
				<tr>
					<td>Student Name</td>
					<td><input type="text" name="studentName" /></td>
				</tr>
				
				
				
				

			</table>
			<input type="submit" value="Submit" />
		</form>
</div>
  test 
</body>
</html>