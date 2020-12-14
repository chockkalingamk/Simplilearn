package com.project.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.bean.Students;
import com.project.bean.Subjects;
import com.project.util.HibernateUtil;

public class ClassesStudentsDaoImpl implements ClassesStudentsDao{

	@Override
	public void saveClassesStudents(Students students) {
		// TODO Auto-generated method stub
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(students);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Students> getMappedStudentForClass(String classId) {
		// TODO Auto-generated method stub

        Transaction trans = null;
        List<Students> studList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			Query query = session.createQuery("SELECT distinct std FROM Students std where  std.classes.classId = :id");
	        query.setParameter("id", Integer.parseInt(classId));
	        studList = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studList;
	}
}
