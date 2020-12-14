package com.project.main;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.bean.Users;
import com.project.dao.UsersDao;
import com.project.dao.UsersDaoImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private UsersDao userDao;

	public void init() {
		userDao = new UsersDaoImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		Users loginUser = new Users();

		loginUser.setUserName(request.getParameter("userName"));
		loginUser.setPassword(request.getParameter("password"));

		try {

			if (userDao.checkuser(loginUser)) {

				response.sendRedirect("loginSuccess.jsp");
				HttpSession session = request.getSession();
				session.setAttribute("name", loginUser.getUserName());
				session.setMaxInactiveInterval(5);

			} else {
				response.sendRedirect("loginError.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
