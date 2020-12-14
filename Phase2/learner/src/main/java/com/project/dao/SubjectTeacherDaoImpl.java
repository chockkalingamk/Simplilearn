package com.project.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.bean.Subjects;
import com.project.bean.SubjectsClasses;
import com.project.util.HibernateUtil;

public class SubjectTeacherDaoImpl implements SubjectTeacherDao{

	@Override
	public void saveSubjectTeacher(SubjectsClasses subjClasses) {
		// TODO Auto-generated method stub
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.saveOrUpdate(subjClasses);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
