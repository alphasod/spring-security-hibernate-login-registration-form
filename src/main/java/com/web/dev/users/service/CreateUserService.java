package com.web.dev.users.service;
import com.web.dev.users.dao.UserCreateDao;
import com.web.dev.users.model.User;

public class CreateUserService {
 
 private UserCreateDao userCreateDao;

    public void createUser(User user) {
        userCreateDao.createUser(user);
    }
 public UserCreateDao getUserCreateDao() {
		return userCreateDao;
	}

	public void setUserCreateDao(UserCreateDao userCreateDao) {
		this.userCreateDao = userCreateDao;
	}
}