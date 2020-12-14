<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.project.bean.* "%>
<%@ page import="java.util.* "%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
<%@include file="main.css"%>
</style>
</head>
<body>

	<div class="sidenav">
		<%@ include file="menu.jsp"%>
	</div>

	<div class="main">
		<h1>Class Subject Form</h1>
		<form action="<%=request.getContextPath()%>/subjectClasses"
			method="post">
			<table style="with: 100%" border="0">
				<tr>
					<td>Class Name</td>
					<%
						ArrayList<Classes> listObj = (ArrayList<Classes>) request.getAttribute("listClasses");
					%>


					<td><select name="classId" size="<%listObj.size();%>"
						multiple>
							<option value="">--Select---</option>
							<%
								
								for (Iterator i = listObj.iterator(); i.hasNext();) {
									Classes c = (Classes) i.next();
							%>
							<option value="<%=c.getClassId()%>">
								<%=c.getClassName()%>||<%=c.getStandardName()%>||<%=c.getStandardSection()%>
							</option>
							<% } %>
					</SELECT></td>
				</tr>
				<tr>

				</tr>
				<tr>
					<td>Subject Name</td>
					<%
						ArrayList<Classes> listSubjectObj = (ArrayList<Classes>) request.getAttribute("listSubject");
					%>


					<td><select name="subjectId" size="<%listSubjectObj.size();%>">
							<option value="">--Select---</option>
							<%
								for (Iterator i = listSubjectObj.iterator(); i.hasNext();) {
									Subjects c = (Subjects) i.next();
							%>
							<option value="<%=c.getSubjectId()%>">
								<%=c.getSubjectName()%>
							</option>
							<% } %>
					</SELECT></td>
				</tr>

			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
	test
</body>
</html>