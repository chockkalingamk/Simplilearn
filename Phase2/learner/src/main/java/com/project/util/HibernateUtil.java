package com.project.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.bean.Users;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() throws Exception {
		
		// Get a reference to the SessionFactory
		sessionFactory = new Configuration()
    								.configure("hibernate.cfg.xml")
    								.addAnnotatedClass(Users.class)
    								.buildSessionFactory();
		
		
		return sessionFactory;
	}

}
