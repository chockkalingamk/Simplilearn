package com.project.main;

import java.io.IOException;
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

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

	public void init() {

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassesDao dao = new ClassesDaoImpl();
		try {

			List<Classes> listClasses = dao.getClasses();
			request.setAttribute("listClasses", listClasses);

			RequestDispatcher dispatcher = request.getRequestDispatcher("report.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		ClassesDao dao = new ClassesDaoImpl();
		
		SubjectClassesDao clsSubDao = new SubjectClassesDaoImpl();
		ClassesStudentsDao clsStudDao = new ClassesStudentsDaoImpl();
		String classId = request.getParameter("classId");
		List<Subjects> listSubj =  clsSubDao.getMappedSubjectForClass(classId);
		request.setAttribute("listSubj", listSubj);
		List<SubjectsClasses> listTeach = clsSubDao.getMappedTeacherForClass(classId);
		request.setAttribute("listTeach", listTeach);
		List<Students> listStuds = clsStudDao.getMappedStudentForClass(classId);
		request.setAttribute("listStuds", listStuds);
		List<Classes> listClasses = dao.getClasses();
		request.setAttribute("listClasses", listClasses);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("report.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
