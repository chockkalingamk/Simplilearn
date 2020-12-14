package com.project.dao;

import java.util.List;

import com.project.bean.Subjects;
import com.project.bean.SubjectsClasses;
import com.project.bean.Teachers;

public interface SubjectClassesDao {
	public void saveSubjectClasses(SubjectsClasses subjClasses);
	public List<Subjects> getMappedSubjectForClass(String classId);
	public List<SubjectsClasses> getMappedTeacherForClass(String classId);
}