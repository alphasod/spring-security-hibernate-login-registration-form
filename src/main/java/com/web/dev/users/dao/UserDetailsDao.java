package com.web.dev.users.dao;
import com.web.dev.users.model.User;

public interface UserDetailsDao {

	User findByUserName(String username);

}