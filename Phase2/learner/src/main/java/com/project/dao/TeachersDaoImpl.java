package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.bean.Teachers;
import com.project.util.HibernateUtil;

public class TeachersDaoImpl implements TeachersDao{


	@Override
	public void saveTeachers(Teachers teacher) {
		// TODO Auto-generated method stub
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(teacher);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Teachers> getTeachers() {
		// TODO Auto-generated method stub
		Transaction trans = null;
		List<Teachers> techerList = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			//session.save(teacher);
			techerList = session.createQuery("SELECT a from Teachers a ", Teachers.class).getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return techerList;
	}

}
