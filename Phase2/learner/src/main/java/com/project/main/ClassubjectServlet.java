package com.project.main;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.bean.Classes;
import com.project.bean.Subjects;
import com.project.dao.ClassesDao;
import com.project.dao.ClassesDaoImpl;
import com.project.dao.SubjectsDao;
import com.project.dao.SubjectsDaoImpl;

@WebServlet("/subjectClasses")
public class ClassubjectServlet extends HttpServlet {
	
	public void init() {
		
	}
	
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
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) {

			Classes classObj = new Classes();
			Subjects subjObj = new Subjects();
			//Set<Classes> clsSet = new HashSet<Classes>();
			String[] classIdArr = request.getParameterValues("className");
			subjObj.setSubjectName(request.getParameter("subjectName")); 
			
			for (String s : classIdArr) {
				int id = Integer.parseInt(s);
				classObj.setClassId(id);
				//clsSet.add(classObj);
				
			}
			//subjObj.setClassObj();
			
			SubjectsDao subDao = new SubjectsDaoImpl();
			subDao.saveSubject(subjObj);
			ClassesDao dao = new ClassesDaoImpl();
			List<Classes> listClasses = dao.getClasses();
            request.setAttribute("listClasses", listClasses);
            
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
