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
import com.project.bean.Subjects;
import com.project.bean.SubjectsClasses;
import com.project.dao.ClassesDao;
import com.project.dao.ClassesDaoImpl;
import com.project.dao.SubjectClassesDao;
import com.project.dao.SubjectClassesDaoImpl;
import com.project.dao.SubjectsDao;
import com.project.dao.SubjectsDaoImpl;

@WebServlet("/subjectClasses")
public class SubjectClassesServlet extends HttpServlet {

	public void init() {

	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassesDao dao = new ClassesDaoImpl();
		SubjectsDao subjDao = new SubjectsDaoImpl();
		try {

			List<Classes> listClasses = dao.getClasses();
			request.setAttribute("listClasses", listClasses);

			List<Subjects> listSubject = subjDao.getSubjects();
			request.setAttribute("listSubject", listSubject);

			RequestDispatcher dispatcher = request.getRequestDispatcher("subjectClasses.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		Subjects subj = new Subjects();
		Classes cls = new Classes();
		
		SubjectsClasses classSubObj = new SubjectsClasses();
		SubjectClassesDao clsSubDao = new SubjectClassesDaoImpl();

		String[] classIdArr = request.getParameterValues("classId");
		subj.setSubjectId(Integer.parseInt(request.getParameter("subjectId")));
		classSubObj.setSubjects(subj);
		classSubObj.setCreatedBy("admin");
		classSubObj.setCreatedDate(LocalDateTime.now().toString());
		
		for (String s : classIdArr) {
			int id = Integer.parseInt(s);
			cls.setClassId(id);
			classSubObj.setClasses(cls);
			
			clsSubDao.saveSubjectClasses(classSubObj);

		}

		
		ClassesDao dao = new ClassesDaoImpl();
		List<Classes> listClasses = dao.getClasses();
		request.setAttribute("listClasses", listClasses);
		SubjectsDao subDao = new SubjectsDaoImpl();
		List<Subjects> listSubject = subDao.getSubjects();
		request.setAttribute("listSubject", listSubject);

		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectClasses.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
