package com.project.dao;

import java.util.List;

import com.project.bean.Classes;

public interface ClassesDao {
	
	public void saveClass(Classes classObj);
	
	public List<Classes> getClasses();
	
	public Classes getClass(int id);

}
