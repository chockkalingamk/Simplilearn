package com.project.dao;

import com.project.bean.Users;

public interface UsersDao {
	
	public Users getUser(Users user);
	
	public boolean checkuser(Users user);
}
