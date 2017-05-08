package com.Sanish.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Sanish.dao.AudioDAO;
import com.Sanish.entity.Audio;
import com.Sanish.entity.Track;

@Repository
public class AudioDAOImpl implements AudioDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Transaction trans;
	
	Session session;

	public int insert(Audio audio) {
		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		session.save(audio);
		
		trans.commit();
		
		session.close();
		
		return 1;
		
	}

	public Audio getById(int id) {
	
		session = sessionFactory.openSession();
		
		Audio audio = session.get(Audio.class, id);
		
		session.close();
		
		return audio;
	}

	public int update(Audio audio) {

		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		session.saveOrUpdate(audio);
		
		trans.commit();
		
		session.close();
		
		return 1;
		
	}

	public int delete(Audio audio) {
	
		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		session.delete(audio);
		
		trans.commit();
		
		session.close();
		
		return 1;
	}

	public List<Audio> getAll() {
		
		String hql = "FROM Audio";
		
		session =sessionFactory.openSession();
		
		List<Audio> audio = session.createQuery(hql).list();
		
		session.close();
		
		return audio;
	}

}
