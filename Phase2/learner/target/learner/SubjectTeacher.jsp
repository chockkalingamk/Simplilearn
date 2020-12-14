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
<script type="text/javascript">
	var requestObj = false;

	if (window.XMLHttpRequest) {
		requestObj = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		requestObj = new ActiveXObject("Microsoft.XMLHTTP");
	}

	function getSubjects() {
		var select = document.getElementById('classId');
		var currentClass = select.options[select.selectedIndex].value;
		if (requestObj) {
			requestObj.open("GET", "/learner/loadSubject?classId="
					+ currentClass, true);
			requestObj.send();

			requestObj.onreadystatechange = function() {

				if (requestObj.readyState == 4 && requestObj.status == 200) {

					var JSONObject = JSON.parse(requestObj.responseText);

					for ( var prop in JSONObject) {
						document.getElementById("subjectId").options.add(new Option(JSONObject[prop],prop));
					}

				}
			}

		}
	}
</script>
</head>
<body>

	<div class="sidenav">
		<%@ include file="menu.jsp"%>
	</div>

	<div class="main">
		<h1>Subject Teacher Form</h1>
		<form action="<%=request.getContextPath()%>/subjectTeacher"
			method="post">
			<table style="with: 100%" border="0">
				<tr>
					<td>Class Name</td>
					<%
						ArrayList<Classes> listObj = (ArrayList<Classes>) request.getAttribute("listClasses");
					%>


					<td><select name="classId" id="classId"
						size="<%listObj.size();%>" OnChange="getSubjects()">
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
				<tr>

				</tr>
				<tr>
					<td>Subject Name</td>


					<td><select name="subjectId" id="subjectId">
							<option value="">--Select---</option>

					</SELECT></td>
				</tr>
				<tr>
					<td>Teacher Name</td>
					<%
						ArrayList<Teachers> listTeacherObj = (ArrayList<Teachers>) request.getAttribute("listTeacher");
					
					%>


					<td><select name="teacherId" size="<%listTeacherObj.size();%>">
							<option value="">--Select---</option>
							<%
								for (Iterator i = listTeacherObj.iterator(); i.hasNext();) {
								Teachers c = (Teachers) i.next();
							%>
							<option value="<%=c.gettId()%>">
								<%=c.getTeacherName()%>
							</option>
							<%
								}
							%>
					</SELECT></td>
				</tr>



			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
	test
</body>
</html>