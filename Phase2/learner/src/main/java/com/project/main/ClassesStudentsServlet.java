package com.project.main;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Classes;
import com.project.bean.Students;
import com.project.bean.Subjects;
import com.project.bean.SubjectsClasses;
import com.project.dao.ClassesDao;
import com.project.dao.ClassesDaoImpl;
import com.project.dao.ClassesStudentsDao;
import com.project.dao.ClassesStudentsDaoImpl;
import com.project.dao.SubjectClassesDao;
import com.project.dao.SubjectClassesDaoImpl;
import com.project.dao.SubjectsDao;
import com.project.dao.SubjectsDaoImpl;

@WebServlet("/classesStudents")
public class ClassesStudentsServlet extends HttpServlet {

	public void init() {

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassesDao dao = new ClassesDaoImpl();
		try {

			List<Classes> listClasses = dao.getClasses();
			request.setAttribute("listClasses", listClasses);

			RequestDispatcher dispatcher = request.getRequestDispatcher("classesStudents.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Classes cls = new Classes();
		Students std = new Students();
		ClassesStudentsDao classesStudentDao = new ClassesStudentsDaoImpl();

		String classId = request.getParameter("classId");
		std.setStudentId(request.getParameter("studentId"));
		std.setStudentName(request.getParameter("studentName"));
		cls.setClassId(Integer.parseInt(classId));
		std.setClasses(cls);
		std.setCreatedBy("admin");
		std.setCreatedDate(LocalDateTime.now().toString());
		classesStudentDao.saveClassesStudents(std);
				
		ClassesDao dao = new ClassesDaoImpl();
		List<Classes> listClasses = dao.getClasses();
		request.setAttribute("listClasses", listClasses);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("classesStudents.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
