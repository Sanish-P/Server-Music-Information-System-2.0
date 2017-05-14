package com.Sanish.dao;

import java.util.List;

import com.Sanish.entity.User;

public interface UserDAO {
	
	int insert(User user);
	User getById(int id);
	int update(User user);
	int delete(User user);
	List<User> getByUsername(String username);
	
	List<User> getAll();

}
