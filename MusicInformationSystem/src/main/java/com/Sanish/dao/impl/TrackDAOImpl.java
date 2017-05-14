package com.Sanish.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Sanish.dao.TrackDAO;
import com.Sanish.entity.Track;


@Repository
public class TrackDAOImpl implements TrackDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	Transaction trans;
	
	Session session;

	public int insert(Track track) {
		
		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		int id = (Integer) session.save(track);
		
		trans.commit();
		
		session.close();
		
		return id;
		
	}

	public Track getById(int id) {
		
		session = sessionFactory.openSession();
		
		Track track = session.get(Track.class, id);
		
		session.close();
		
		return track;
	
	}

	public int update(Track track) {
		
		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
				
		session.saveOrUpdate(track);
		
		trans.commit();
		
		session.close();
		
		return 1;
	}

	public int delete(Track track) {
		
		session = sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		session.delete(track);
		
		trans.commit();
		
		session.close();
		
		return 1;
	}

	public List<Track> getAll() {
		
		String hql = "FROM Track";
		
		session =sessionFactory.openSession();
		
		trans = session.beginTransaction();
		
		List<Track> tracks = session.createQuery(hql).list();
		
		trans.commit();
		
		session.close();
		
		return tracks;
	}

}
