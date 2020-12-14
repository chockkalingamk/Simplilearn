package com.project.main;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.bean.Subjects;
import com.project.dao.SubjectClassesDao;
import com.project.dao.SubjectClassesDaoImpl;
@WebServlet("/loadSubject")
public class LoadServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classId = request.getParameter("classId");
		SubjectClassesDao subjDao = new SubjectClassesDaoImpl();
		List<Subjects> listSubject = subjDao.getMappedSubjectForClass(classId);
	    Map<String, String> options = new LinkedHashMap<>();
	    for(Subjects subject:listSubject) {
	    options.put(String.valueOf(subject.getSubjectId()),subject.getSubjectName() );
	    }
	    String json = new Gson().toJson(options);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}
}
