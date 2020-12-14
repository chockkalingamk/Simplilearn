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
		<%@ include file="menu.jsp"%>
	</div>

	<div class="main">
		<h1>Report</h1>
		<form action="<%=request.getContextPath()%>/report" method="post">
			<table style="with: 100%">
				<tr>
					<td>Class Name</td>
					<%
						ArrayList<Classes> listObj = (ArrayList<Classes>) request.getAttribute("listClasses");
					%>


					<td><select name="classId" size="<%listObj.size();%>">
							<option value="">--Select---</option>
							<%
								for (Iterator i = listObj.iterator(); i.hasNext();) {
								Classes c = (Classes) i.next();
							%>
							<option value="<%=c.getClassId()%>">
								<%=c.getClassName()%>||<%=c.getStandardName()%>||<%=c.getStandardSection()%>
							</option>
							<%
								}
							%>
					</SELECT></td>
				</tr>







			</table>
			<input type="submit" value="Report" />
			
			<%
			ArrayList<SubjectsClasses> listTeach = (ArrayList<SubjectsClasses>) request.getAttribute("listTeach");
			if (listTeach != null) {
			%>
			<table style="with: 100%">
				<tr>
					<td>Subject Wise Teachers List</td>
				</tr>
				<tr>
					<td>Class Name</td>
					<td>Standard Name</td>
					<td>Standard Section</td>
					<td>Subject Id</td>
					<td>Subject Name</td>
					<td>Teacher Id</td>
					<td>Teacher Name</td>
				</tr>
				<%
					for (Iterator i = listTeach.iterator(); i.hasNext();) {
					SubjectsClasses c = (SubjectsClasses) i.next();
				%>
				<tr>
					<td><%=c.getClasses().getClassName()%> </td>
					<td><%=c.getClasses().getStandardName()%> </td>
					<td><%=c.getClasses().getStandardSection()%> </td>
					<td><%=c.getSubjects().getSubjectId()%></td>
					<td><%=c.getSubjects().getSubjectName()%></td>
					<td><%=c.getTeachers().getTeacherId()%></td>
					<td><%=c.getTeachers().getTeacherName()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}

			ArrayList<Students> listStuds = (ArrayList<Students>) request.getAttribute("listStuds");
			if (listStuds != null) {
			%>
			<table style="with: 100%">
				<tr>
					<td>Students List</td>
				</tr>
				<tr>
					<td>Student Id</td>
					<td>Student Name</td>
				</tr>
				<%
					for (Iterator i = listStuds.iterator(); i.hasNext();) {
					Students c = (Students) i.next();
				%>
				<tr>
					<td><%=c.getStudentId()%></td>
					<td><%=c.getStudentName()%></td>
				</tr>
				<%
					}
				%>
			</table>
			<%
				}
			%>
		</form>
	</div>
	test
</body>
</html>