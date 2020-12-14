package com.project.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Classes;
import com.project.bean.Users;
import com.project.dao.ClassesDao;
import com.project.dao.ClassesDaoImpl;
import com.project.dao.UsersDao;
import com.project.dao.UsersDaoImpl;

@WebServlet("/class")
public class ClassesServlet extends HttpServlet {

	private ClassesDao classDao;

	public void init() {
		classDao = new ClassesDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		Classes classObj = new Classes();

		classObj.setClassName(request.getParameter("className"));
		classObj.setStandardName(request.getParameter("standardName"));
		classObj.setStandardSection(request.getParameter("standardSection"));
		classObj.setCreatedBy("admin");
		classObj.setCreatedDate(LocalDateTime.now().toString());
		try {
			classDao.saveClass(classObj);
			
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
