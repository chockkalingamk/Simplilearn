package com.project.dao;

import java.util.List;

import com.project.bean.Subjects;

public interface SubjectsDao {
	
	public void saveSubject(Subjects subject);
	
	public List<Subjects> getSubjects();
	
	public void saveOrUpdateSubject(Subjects subject);

}
