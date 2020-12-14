package com.project.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.bean.Subjects;
import com.project.bean.SubjectsClasses;
import com.project.bean.Teachers;
import com.project.util.HibernateUtil;

public class SubjectClassesDaoImpl implements SubjectClassesDao{

	@Override
	public void saveSubjectClasses(SubjectsClasses subjClasses) {
		// TODO Auto-generated method stub
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(subjClasses);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Subjects> getMappedSubjectForClass(String classId) {
		// TODO Auto-generated method stub
		
        Transaction trans = null;
        List<Subjects> subjList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			Query query = session.createQuery("SELECT distinct subjects FROM SubjectsClasses cst where  cst.classes.classId = :id");
	        query.setParameter("id", Integer.parseInt(classId));
			subjList = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjList;
	}

	@Override
	public List<SubjectsClasses> getMappedTeacherForClass(String classId) {
		// TODO Auto-generated method stub
		 Transaction trans = null;
	        List<SubjectsClasses> techList = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				trans = session.beginTransaction();
				Query query = session.createQuery("SELECT distinct cst FROM SubjectsClasses cst where  cst.classes.classId = :id");
		        query.setParameter("id", Integer.parseInt(classId));
		        techList = query.getResultList();
				trans.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return techList;
	}

}
