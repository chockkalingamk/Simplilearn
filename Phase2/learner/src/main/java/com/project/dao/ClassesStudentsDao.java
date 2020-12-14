package com.project.dao;

import java.util.List;

import com.project.bean.Students;

public interface ClassesStudentsDao {
	public void saveClassesStudents(Students students);
	public List<Students> getMappedStudentForClass(String classId);
}