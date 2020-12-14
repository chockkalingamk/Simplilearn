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
import com.project.bean.Teachers;
import com.project.dao.ClassesDao;
import com.project.dao.ClassesDaoImpl;
import com.project.dao.SubjectTeacherDao;
import com.project.dao.SubjectTeacherDaoImpl;
import com.project.dao.SubjectsDao;
import com.project.dao.SubjectsDaoImpl;
import com.project.dao.TeachersDao;
import com.project.dao.TeachersDaoImpl;

@WebServlet("/subjectTeacher")
public class SubjectTeacherServlet extends HttpServlet {

	public void init() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassesDao dao = new ClassesDaoImpl();
		SubjectsDao subjDao = new SubjectsDaoImpl();
		TeachersDao techDao = new TeachersDaoImpl();
		try {

			List<Classes> listClasses = dao.getClasses();
			request.setAttribute("listClasses", listClasses);

			List<Subjects> listSubject = subjDao.getSubjects();
			request.setAttribute("listSubject", listSubject);

			List<Teachers> listTeacher = techDao.getTeachers();
			request.setAttribute("listTeacher", listTeacher);

			RequestDispatcher dispatcher = request.getRequestDispatcher("subjectTeacher.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

		Subjects subj = new Subjects();
		Classes cls = new Classes();
		Teachers teh = new Teachers();
		SubjectsClasses classSubObj = new SubjectsClasses();
		SubjectTeacherDao clsSubDao = new SubjectTeacherDaoImpl();

		cls.setClassId(Integer.parseInt(request.getParameter("classId")));
		subj.setSubjectId(Integer.parseInt(request.getParameter("subjectId")));
		teh.settId(Integer.parseInt(request.getParameter("teacherId")));
		
		classSubObj.setCreatedBy("admin");
		classSubObj.setCreatedDate(LocalDateTime.now().toString());

		classSubObj.setClasses(cls);
		classSubObj.setSubjects(subj);
		classSubObj.setTeachers(teh);
		clsSubDao.saveSubjectTeacher(classSubObj);

		ClassesDao dao = new ClassesDaoImpl();
		List<Classes> listClasses = dao.getClasses();
		request.setAttribute("listClasses", listClasses);
		SubjectsDao subDao = new SubjectsDaoImpl();
		List<Subjects> listSubject = subDao.getSubjects();
		request.setAttribute("listSubject", listSubject);
		TeachersDao techDao = new TeachersDaoImpl();
		List<Teachers> listTeacher = techDao.getTeachers();
		request.setAttribute("listTeacher", listTeacher);

		RequestDispatcher dispatcher = request.getRequestDispatcher("subjectTeacher.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
