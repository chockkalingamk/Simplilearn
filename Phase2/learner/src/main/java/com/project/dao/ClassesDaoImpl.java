package com.project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.bean.Classes;
import com.project.util.HibernateUtil;

public class ClassesDaoImpl implements ClassesDao {

	@Override
	public void saveClass(Classes classObj) {
		// TODO Auto-generated method stub
		Transaction trans = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			session.save(classObj);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Classes> getClasses() {
		// TODO Auto-generated method stub
		Transaction trans = null;
		List<Classes> listObj = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			listObj = session.createQuery("SELECT  a FROM Classes a", Classes.class).getResultList();
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listObj;
	}

	@Override
	public Classes getClass(int id) {
		// TODO Auto-generated method stub
		Transaction trans = null;
		Classes clsObj = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			trans = session.beginTransaction();
			clsObj = session.get(Classes.class, id);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clsObj;
	}

}
