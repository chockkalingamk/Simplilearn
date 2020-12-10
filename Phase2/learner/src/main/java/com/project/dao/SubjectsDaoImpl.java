package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.bean.Classes;
import com.project.bean.Subjects;
import com.project.util.HibernateUtil;

public class SubjectsDaoImpl implements SubjectsDao{


	@Override
	public void saveSubject(Subjects subject) {
		// TODO Auto-generated method stub
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(subject);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void saveOrUpdateSubject(Subjects subject) {
		// TODO Auto-generated method stub
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.saveOrUpdate(subject);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public List<Subjects> getSubjects() {
		// TODO Auto-generated method stub
		Transaction trans = null;
		List<Subjects> listObj = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			listObj = session.createQuery("SELECT  a FROM Subjects a", Subjects.class).getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listObj;
	}

}
