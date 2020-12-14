package com.project.dao;

import java.util.List;

import com.project.bean.Teachers;

public interface TeachersDao {
	
	public void saveTeachers(Teachers teacher);
	
	public List<Teachers> getTeachers();

	

}
