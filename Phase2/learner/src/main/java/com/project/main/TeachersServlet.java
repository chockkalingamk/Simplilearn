package com.project.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Teachers;
import com.project.dao.TeachersDao;
import com.project.dao.TeachersDaoImpl;




@WebServlet("/teacher")
public class TeachersServlet extends HttpServlet {

	private TeachersDao teachersDao;

	public void init() {
		teachersDao = new TeachersDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		Teachers teacherObj = new Teachers();

		teacherObj.setTeacherId(request.getParameter("teacherId"));
		teacherObj.setTeacherName(request.getParameter("teacherName"));
		teacherObj.setCreatedBy("admin");
		teacherObj.setCreatedDate(LocalDateTime.now().toString());
		try {
			teachersDao.saveTeachers(teacherObj);
			
			response.sendRedirect("loginSuccess.jsp");
			
			/*if (userDao.checkuser(classObj)) {

				response.sendRedirect("loginSucces.jsp");

			} else {
				response.sendRedirect("login.jsp");
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
