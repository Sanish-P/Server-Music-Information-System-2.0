package com.Sanish.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Sanish.dao.UserDAO;
import com.Sanish.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	Transaction trans;
	
	Session session;


	public int insert(User user) {
		
		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		session.save(user);
		
		trans.commit();
		
		session.close();
		
		return 1;
	}

	public User getById(int id) {

		session = sessionFactory.openSession();
		
		User user = session.get(User.class, id);
		
		session.close();
		
		return user;
		
		
	}

	public int update(User user) {
	
		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		session.saveOrUpdate(user);
		
		trans.commit();
		
		session.close();
		
		return 1;

		
	}

	public int delete(User user) {
		
		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		session.delete(user);
		
		trans.commit();
		
		session.close();
		
		return 1;

		
	}

	public List<User> getAll() {
		
		String hql = "FROM User";
		
		session =sessionFactory.openSession();
		
		List<User> users = session.createQuery(hql).list();
		
		session.close();
		
		return users;
	}

}
