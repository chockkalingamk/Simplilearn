package com.project.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.bean.Users;
import com.project.util.HibernateUtil;

public class UsersDaoImpl implements UsersDao{

	@Override
	public Users getUser(Users user) {
		// TODO Auto-generated method stub
		
		Transaction trans = null;
		Users userObj = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			trans = session.beginTransaction();
			
			userObj = (Users) session.createQuery("FROM Users U WHERE U.userName = :userName").setParameter("userName", user.getUserName())
	                .uniqueResult();
			
			trans.commit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return userObj;
	}

	@Override
	public boolean checkuser(Users user) {
		// TODO Auto-generated method stub
		Users dataBaseObj = getUser(user);
		boolean check = false;
		
		if (dataBaseObj.getPassword().equalsIgnoreCase(user.getPassword()))
			check =true;
		
		return check;
	}

}
