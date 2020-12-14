package com.project.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Subjects;
import com.project.dao.SubjectsDao;
import com.project.dao.SubjectsDaoImpl;

@WebServlet("/subject")
public class SubjectsServlet extends HttpServlet {

	private SubjectsDao subjectDao;

	public void init() {
		subjectDao = new SubjectsDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		Subjects subjectObj = new Subjects();

		subjectObj.setSubjectCode(request.getParameter("subjectCode"));
		subjectObj.setSubjectName(request.getParameter("subjectName"));
		subjectObj.setCreatedBy("admin");
		subjectObj.setCreatedDate(LocalDateTime.now().toString());
		try {
			subjectDao.saveSubject(subjectObj);
			
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
